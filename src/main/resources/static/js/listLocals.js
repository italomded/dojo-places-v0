function showDeleteModal(id) {
    const modalElement = document.getElementById('staticBackdrop');
    document.getElementById('confirmDeleteButton').onclick = () => deleteLocal(id);
    const modal = new bootstrap.Modal(modalElement);
    modal.show();
}

async function deleteLocal(id) {
    await fetch(
        "/local/deletar/" + id,
        {
            method: "POST"
        }
    ).then(_ => {
        window.location = "/local"
    })
}