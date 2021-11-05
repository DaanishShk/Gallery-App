let flg = false;

async function checkImage(url) {

    flg = false;

    const res = await fetch(url);
    const buff = await res.blob();
    console.log(buff);

    if (buff.type.startsWith('image/')) {
        let imgEle = document.getElementById("image");
        console.log(imgEle);
        imgEle.src = url;
        console.log(imgEle.src);

        flg = true;
    }

}

function checkBeforeSubmit() {
    const name = document.getElementById("name");
    const description = document.getElementById("description");

    let message = document.getElementById("invalid-image-text");

    if(!name.value || !description.value) {
        message.style.display = 'block';
        message.innerText = "Fill in fields";
        return;
    }

    if (flg) {
        const form = document.getElementById("add-form")
        form.submit();
    }
    else {
        message.style.display = 'block';
        message.innerText = "Image link invalid";
    }
}