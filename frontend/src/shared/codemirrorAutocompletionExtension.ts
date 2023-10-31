import { Extension } from '@codemirror/state'
import { autocompletion, CompletionContext, CompletionResult } from '@codemirror/autocomplete'

interface CodeMirrorAutocompletionExtensionConfig {
  language: string
}
let codeMirrorAutocompletionExtensionConfig: CodeMirrorAutocompletionExtensionConfig | undefined

function myCompletions(context: CompletionContext) {
  let word = context.matchBefore(/\w*/)

  if (word === null || (word.from == word.to && !context.explicit)) {
    return null
  }

  return {
    from: word.from,
    options: [
      { label: 'match', type: 'keyword' },
      { label: 'hello', type: 'variable', info: '(World)' },
      { label: 'magic', type: 'text', apply: '⠁⭒*.✩.*⭒⠁', detail: 'macro' }
    ]
  }
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
