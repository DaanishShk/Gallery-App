let flg = false;

async function checkImage(url){

    const res = await fetch(url);
    const buff = await res.blob();
    console.log(buff);

    if(buff.type.startsWith('image/')) {
        let imgEle = document.getElementById("image");
        console.log(imgEle);
        imgEle.src = url;
        console.log(imgEle.src);
    }

}

function checkBeforeSubmit() {

}