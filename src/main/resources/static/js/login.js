// HTML structure for the login screen
const container = document.createElement("div");
container.style.display = "flex";
container.style.flexDirection = "column";
container.style.justifyContent = "center";
container.style.alignItems = "center";
container.style.height = "100vh";
container.style.backgroundColor = "#f4f4f4";
container.style.fontFamily = "Arial, sans-serif";

// Title
const title = document.createElement("h2");
title.textContent = "Login";
title.style.marginBottom = "20px";
container.appendChild(title);

// Username Input
const usernameInput = document.createElement("input");
usernameInput.type = "text";
usernameInput.placeholder = "Username";
usernameInput.style.padding = "10px";
usernameInput.style.marginBottom = "10px";
usernameInput.style.width = "300px";
usernameInput.style.border = "1px solid #ccc";
usernameInput.style.borderRadius = "5px";
container.appendChild(usernameInput);

// Password Input
const passwordInput = document.createElement("input");
passwordInput.type = "password";
passwordInput.placeholder = "Password";
passwordInput.style.padding = "10px";
passwordInput.style.marginBottom = "20px";
passwordInput.style.width = "300px";
passwordInput.style.border = "1px solid #ccc";
passwordInput.style.borderRadius = "5px";
container.appendChild(passwordInput);

// Login Button
const loginButton = document.createElement("button");
loginButton.textContent = "Login";
loginButton.style.padding = "10px 20px";
loginButton.style.border = "none";
loginButton.style.borderRadius = "5px";
loginButton.style.backgroundColor = "#007bff";
loginButton.style.color = "#fff";
loginButton.style.cursor = "pointer";

container.appendChild(loginButton);

// Append to body
document.body.appendChild(container);

// Button click event
loginButton.addEventListener("click", () => {
    const username = usernameInput.value;
    const password = passwordInput.value;

    if (username && password) {
        alert(`Welcome, ${username}!`); // Replace this with actual login logic
    } else {
        alert("Please enter both username and password.");
    }
});