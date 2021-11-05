function onClickNavigation(pageNo) {
    let url = document.location.href.split('?')[0] + '?';
    url += `pageNo=${pageNo}` + '#marker'
    // console.log(url)
    document.location.href = url;
}

document.addEventListener("DOMContentLoaded", function (event) {
    console.log(/.*search.*/.test(document.location.href));
    if (/.*search.*/.test(document.location.href)) {
        let div = document.getElementById("navigation-buttons");
        // console.log(div);
        // console.log(div.style)
        // console.log(div.style.display)
        div.style.display = 'none';
        // console.log(div.style.display)
    }
});