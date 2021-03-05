// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I did not learn how to ride a bike until 13.', 'My favorite color is red.',
       'Puerto Rico is the oldest colony in the world at the moment, and I am one of its residents.', 
    'I have a mild obsession with instant ramen with boiled eggs.',
     'My favorite saga is Star Wars.', 'I used to practice Taekwondo until I had kneee surgery.', 
    'I have 4 siblings; 2 brothers and 2 sisters.', 'I am a professional procrastinator!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}
/**
 * Displays a string fetched from a servlet.
 */
async function displayMessage() {
    const responseFromServer = await fetch('/fetch-hello-world-string');
    const textFromResponse = await responseFromServer.text();

    const dateContainer = document.getElementById('message-cont');
    dateContainer.innerText = textFromResponse;
}
