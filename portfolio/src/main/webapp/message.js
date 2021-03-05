async function displayMessage() {
    const responseFromServer = await fetch('"/fetch-hello-world-string"');
    const textFromResponse = await responseFromServer.text();

    const dateContainer = document.getElementById('message-cont');
    dateContainer.innerText = textFromResponse;
}