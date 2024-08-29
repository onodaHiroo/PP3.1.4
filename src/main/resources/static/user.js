async function getCurrentUser() {
    let temporary = '';
    const tableUser = document.querySelector('#tableUser tbody');
    await userFetch.findCurrentUser()
        .then(response => response.json())
        .then(user => {
            let roles = user.roles.map(role => " " + role.name);
            temporary = `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${roles}</td>
                </tr>
            `;
            tableUser.innerHTML = temporary;

            $(function (){
                let role = ""
                for (let i = 0; i < user.roles.length; i++) {
                    role = user.roles[i].name
                    if (role === "ROLE_ADMIN") {
                        isUser = false;
                    }
                }
                console.log(role);
                if (isUser) {
                    $("#userTable").addClass("show active");
                    $("#userTab").addClass("show active");
                    $("#adminTab").hide();
                } else {
                    $("#adminTable").addClass("show active");
                    $("#adminTab").addClass("show active");
                }
            })
        })
}