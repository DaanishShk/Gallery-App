function onClickEdit() {
    const formDiv = document.getElementById("update-form")
    console.log(formDiv.style);
    formDiv.style.display = formDiv.style.display === 'none' ? 'block': 'none';
}