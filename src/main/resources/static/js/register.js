// HTML kodu: Bir kayıt formu oluşturuluyor
const registerFormHTML = `
  <div class="register-container">
    <h2>Register</h2>
    <form id="registerForm">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required />
      
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required />
      
      <label for="confirmPassword">Confirm Password:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" required />
      
      <button type="submit">Register</button>
    </form>
    <p id="errorMessage" style="color: red; display: none;">Passwords do not match!</p>
  </div>
`;

// Formu sayfaya ekle
document.body.innerHTML = registerFormHTML;

// JavaScript kodu: Form gönderme işlemi
document.getElementById('registerForm').addEventListener('submit', function (event) {
    event.preventDefault();

    // Form değerlerini al
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    // Şifrelerin eşleşip eşleşmediğini kontrol et
    if (password !== confirmPassword) {
        document.getElementById('errorMessage').style.display = 'block';
        return;
    }

    document.getElementById('errorMessage').style.display = 'none';

    // Kullanıcı verilerini konsola yazdır (backend ile entegre edilebilir)
    console.log({
        username: username,
        password: password,
    });

    alert('Registration successful!');
    // Başarılı kayıt durumunda form sıfırlanır
    event.target.reset();
});