import { Extension } from '@codemirror/state'
import {
  autocompletion,
  Completion,
  CompletionContext,
  CompletionInfo,
  CompletionResult,
  insertCompletionText,
  snippetCompletion
} from '@codemirror/autocomplete'
import { EditorView } from 'codemirror'
import CodemirrorApi from '@/api/CodemirrorApi'
import AIRequest from '@/api/AIRequest'
import { ref } from 'vue'

const codemirrorApi = new CodemirrorApi()
export const loading = ref(false)
interface CodeMirrorAutocompletionExtensionConfig {
  language: string
}
let codeMirrorAutocompletionExtensionConfig: CodeMirrorAutocompletionExtensionConfig | undefined

const generalAutocompletionOptions = async (): Promise<Completion[]> => {
  const generalOptions = [
    snippetCompletion('/*\n* ${}\n*/', { label: '/*', detail: 'multi-line comment' }),
    snippetCompletion('@AI_START\n  ${}\n@AI_END', { label: '@AI_START', detail: 'AI completion' })
  ]
  return generalOptions.map((option) => ({
    ...option,
    type: 'generalAutocompletionOption',
    boost: 0,
    section: {
      name: 'General Options'
    }
  }))
}

const aiAutocompletionOptions = async (context: CompletionContext): Promise<Completion[]> => {
  const aiOptions: Completion[] = []
  const aiCompletionRequirement = await extractAiCompletionRequirement(context)
  const request = new AIRequest(
    codeMirrorAutocompletionExtensionConfig?.language,
    aiCompletionRequirement
  )
  loading.value = true
  const aiCompletionOptions = await codemirrorApi.getAiAutocompletion(request)
  loading.value = false
  if (aiCompletionOptions?.statusCode === 200) {
    aiCompletionOptions.suggestions.forEach((option) => {
      aiOptions.push({ label: option })
    })
  }
  return aiOptions.map((option) => ({
    ...option,
    type: 'aiAutocompletionOption',
    boost: 2,
    info: getAiOptionPreview,
    section: {
      name: 'AI Options'
    },
    apply: async (view: EditorView, completion: Completion) => {
      if (context.state.selection.main.from === context.state.selection.main.to) {
        const line = context.state.doc.lineAt(context.state.selection.main.from)
        view.dispatch(
          insertCompletionText(
            view.state,
            await extractLabelWithoutFormatting(completion),
            line.from,
            line.to
          )
        )
      } else {
        view.dispatch(
          insertCompletionText(
            view.state,
            await extractLabelWithoutFormatting(completion),
            context.state.selection.main.from,
            context.state.selection.main.to
          )
        )
      }
    }
  }))
}

const myCompletions = async (context: CompletionContext): Promise<CompletionResult | null> => {
  const currentWord = context.matchBefore(/[\p{Alphabetic}\p{Number}_@/*]*/u)
  if (currentWord === null) return null
  if (context.explicit)
    return {
      from: context.pos,
      options: await aiAutocompletionOptions(context)
    }
  if (!context.explicit)
    return {
      from: currentWord.from,
      options: await generalAutocompletionOptions()
    }
  return null
}

const getAiOptionPreview = async (completion: Completion): Promise<CompletionInfo> => {
  const dom = document.createElement('div')
  dom.style.whiteSpace = 'pre-wrap'
  dom.style.maxHeight = '50vh'
  dom.style.overflow = 'auto'
  dom.style.userSelect = 'none'
  dom.innerHTML = completion.label
  return { dom: dom }
}

const extractLabelWithoutFormatting = async (completion: Completion): Promise<string> => {
  return completion.label.replaceAll('<strong>', '').replaceAll('</strong>', '')
}

const extractAiCompletionRequirement = async (context: CompletionContext): Promise<string> => {
  const aiCompletionRequirementBlockStartIndex = await findAiCompletionRequirementBlockStartIndex(
    context
  )
  const aiCompletionRequirementBlockEndIndex = await findAiCompletionRequirementBlockEndIndex(
    context
  )
  if (aiCompletionRequirementBlockStartIndex === -1 || aiCompletionRequirementBlockEndIndex === -1)
    return ''
  const aiCompletionRequirementBlock = context.state.doc
    .toString()
    .substring(aiCompletionRequirementBlockStartIndex, aiCompletionRequirementBlockEndIndex)
  return aiCompletionRequirementBlock.replace('@AI_START', '').replace('@AI_END', '').trim()
}
const findAiCompletionRequirementBlockEndIndex = async (
  context: CompletionContext
): Promise<number> => {
  let aiCompletionRequirementBlockEndIndex = context.state.doc
    .toString()
    .substring(context.pos)
    .indexOf('@AI_END')
  if (aiCompletionRequirementBlockEndIndex !== -1)
    aiCompletionRequirementBlockEndIndex += context.pos + '@AI_END'.length
  return aiCompletionRequirementBlockEndIndex
}

const findAiCompletionRequirementBlockStartIndex = async (
  context: CompletionContext
): Promise<number> => {
  return context.state.doc.toString().substring(0, context.pos).lastIndexOf('@AI_START')
}

const isInsideAiCompletionRequirementBlock = async (
  context: CompletionContext
): Promise<boolean> => {
  const aiCompletionRequirementBlockStartIndex = await findAiCompletionRequirementBlockStartIndex(
    context
  )
  const aiCompletionRequirementBlockEndIndex = await findAiCompletionRequirementBlockEndIndex(
    context
  )
  return (
    aiCompletionRequirementBlockStartIndex !== -1 && aiCompletionRequirementBlockEndIndex !== -1
  )
}

const customAutocompletion = async (
  context: CompletionContext
): Promise<CompletionResult | null> => {
  return myCompletions(context)
}

const autocompletionExtensionConfig = {
  override: [customAutocompletion],
  activateOnTyping: true,
  closeOnBlur: true
}

const autocompletionExtension: Extension = autocompletion(autocompletionExtensionConfig)

const CodeMirrorAutocompletionExtension = (
  config: CodeMirrorAutocompletionExtensionConfig
): Extension => {
  codeMirrorAutocompletionExtensionConfig = config
  return autocompletionExtension
}
export const codemirrorAutocompletionExtension = CodeMirrorAutocompletionExtension({
  language: 'java'
})
