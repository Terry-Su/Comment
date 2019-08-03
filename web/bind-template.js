// # 1. generate comments dom elements
// # 2. generate recorded comments dom elements

const givenCommentContainerDomId = "{0}"
const urlToFetchComments = "{1}"
// # Initalize
const found = document.getElementById( givenCommentContainerDomId )
let commentContainerElement
if ( found != null ) {
  commentContainerElement = found
} else {
  commentContainerElement = document.createElement( 'div' )
  document.body.appendChild( commentContainerElement )
}

// # 1. generate comments dom elements
const commentingContainerElement = document.createElement( 'div' )
commentingContainerElement.setAttribute('class', 'commenting-container')
commentingContainerElement.innerHTML = `
<textarea id="content"></textarea>
<input type="text" placeholder="（选填）姓名" id="name">
<input type="text" placeholder="（选填）邮箱" id="email">
<button id="button-generate-comment">Comment</button>
`

// # 2. generate recorded comments dom elements
async function generateRecordedCommentsDomElements() {
  const comments = await fetch( urlToFetchComments )
  
}