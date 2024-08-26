let isUser = true;

let listRoles = [
    {id: 1, role: "ROLE_USER"},
    {id: 2, role: "ROLE_ADMIN"}]

$(async function () {
    await userInfo();
})

const userFetch = {
    head: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Referer': null
    },
    findCurrentUser: async () => await fetch(`/user`),
}

async function userInfo() {
    let temporary = '';
    const info = document.querySelector('#info');
    await userFetch.findCurrentUser()
        .then(res => res.json())
        .then(user => {
            let roles = user.roles.map(role => " " + role.name);
            temporary += `
              <p class="navbar-brand text-white">
                    <b><span class="align-middle">${user.email}</span></b>
                    <span class="align-middle">with roles: ${roles}</span>
              </p>
            `;
        });
    info.innerHTML = temporary;
}