async function getNewUserForm() {
    let button = $(`#addUser`);
    let form = $(`#addForm`);
    button.on('click', () => {
        form.show()
    })
}

async function getDefaultModal() {
    $('#defaultModal').modal({
        show: false,
        keyboard: true,
        backdrop: "static"

    }).on("show.bs.modal", (s) => {
        let thisModal = $(s.target);
        let userId = thisModal.attr('data-userid');
        let action = thisModal.attr('data-action');
        switch (action) {
            case 'delete':
                deleteForm(thisModal, userId);
                break;
            // case 'edit':
            //     updateForm(thisModal, userId);
            //     break;

        }
    }).on("hidden.bs.modal", (s1) => {
        let thisModal = $(s1.target);
        thisModal.find('.modal-title').html('');
        thisModal.find('.modal-body').html('');
        thisModal.find('.modal-footer').html('');
    })
}