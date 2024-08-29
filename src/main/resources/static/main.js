let isUser = true;

let listRoles = [
    {id: 1, name: "ROLE_USER"},
    {id: 2, name: "ROLE_ADMIN"}]

$(async function () {
    await getCurrentUser();
    await userInfo();
    await title();
    await getAllUsers();
    await getDefaultModal();
    await create();
    await getNewUserForm();
})

const userFetch = {
    head: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Referer': null
    },
    findCurrentUser: async () => await fetch(`/user`),
    findAllUsers: async () => await fetch(`/admin`),
    addNewUser: async (user) => await fetch('/admin/new', {
        method: 'POST',
        headers: userFetch.head,
        body: JSON.stringify(user),
    }),
    findUserById: async (id) => await fetch(`/admin/show?id=${id}`),
    deleteUser: async (id) => await fetch(`/admin/delete?id=${id}`),
    updateUser: async (user) => await fetch(`/admin/update`, {
        method: 'POST',
        headers: userFetch.head,
        body: JSON.stringify(user)
    }),
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

async function title() {
    let temporary = ''
    const titleTab = document.querySelector('#titleTab');
    if (isUser) {
        temporary = `
            <h1 className="titleTab" id="titleTab">User information page</h1>
            `;
        titleTab.innerHTML = temporary;
    } else {
        temporary = `
            <h1  className="titleTab" id="titleTab">Admin panel</h1>
            `;
        titleTab.innerHTML = temporary;
    }
}