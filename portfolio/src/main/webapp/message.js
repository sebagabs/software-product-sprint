async function displayMessage() {
    const responseFromServer = await fetch('/tester');
    const textFromResponse = await responseFromServer.text();

    const dateContainer = document.getElementById('message-cont');
    dateContainer.innerText = textFromResponse;
}