async function getAllUsers() {
    let temporary = '';
    const table = document.querySelector('#tableUsers tbody');
    await userFetch.findAllUsers()
        .then(response => response.json())
        .then(users => {
            users.forEach(user => {
                let roles = user.roles.map(role => " " + role.name);
                temporary += `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${roles}</td>
                </tr>
               `;
            })
            table.innerHTML = temporary;
        })
}