import { Extension } from '@codemirror/state'
import { autocompletion, CompletionContext, CompletionResult } from '@codemirror/autocomplete'

interface CodeMirrorAutocompletionExtensionConfig {
  language: string
}
let codeMirrorAutocompletionExtensionConfig: CodeMirrorAutocompletionExtensionConfig | undefined

const myCompletions = async (context: CompletionContext): Promise<CompletionResult | null> => {
  let word = context.matchBefore(/\w*/)

  if (word === null || (word.from == word.to && !context.explicit)) {
    return null
  }

  console.log(extractAiCompletionRequirement(context))
  if (context.explicit && await isInsideAiCompletionRequirementBlock(context)) return {
    from: context.pos,
    options: [
      { label: 'hello from ai' }
    ]
  }

  return {
    from: word.from,
    options: [
      { label: 'match', type: 'keyword' },
      { label: 'hello', type: 'variable', info: '(World)' },
      { label: 'magic', type: 'text', apply: '⠁⭒*.✩.*⭒⠁', detail: 'macro' },
      { label: '@AI_START\n  ${}\n@AI_END' }
    ]
  }
}

const extractAiCompletionRequirement = async (context: CompletionContext): Promise<string> => {
  const aiCompletionRequirementBlockStartIndex = await findAiCompletionRequirementBlockStartIndex(context)
  const aiCompletionRequirementBlockEndIndex = await findAiCompletionRequirementBlockEndIndex(context)
  if (aiCompletionRequirementBlockStartIndex === -1 || aiCompletionRequirementBlockEndIndex === -1) return ''
  const aiCompletionRequirementBlock = context.state.doc.toString().substring(aiCompletionRequirementBlockStartIndex, aiCompletionRequirementBlockEndIndex)
  return aiCompletionRequirementBlock
      .replace('@AI_START', '')
      .replace('@AI_END', '')
      .trim()
}
const findAiCompletionRequirementBlockEndIndex = async (context: CompletionContext): Promise<number> => {
  let aiCompletionRequirementBlockEndIndex = context.state.doc.toString().substring(context.pos).indexOf('@AI_END')
  if (aiCompletionRequirementBlockEndIndex !== -1) aiCompletionRequirementBlockEndIndex += context.pos + '@AI_END'.length
  return aiCompletionRequirementBlockEndIndex
}

const findAiCompletionRequirementBlockStartIndex = async (context: CompletionContext): Promise<number> => {
  return context.state.doc.toString().substring(0, context.pos).lastIndexOf('@AI_START')
}

const isInsideAiCompletionRequirementBlock = async (context: CompletionContext): Promise<boolean> => {
  const aiCompletionRequirementBlockStartIndex = await findAiCompletionRequirementBlockStartIndex(context)
  const aiCompletionRequirementBlockEndIndex = await findAiCompletionRequirementBlockEndIndex(context)
  return aiCompletionRequirementBlockStartIndex !== -1 && aiCompletionRequirementBlockEndIndex !== -1
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
