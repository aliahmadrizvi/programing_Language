let h1 = document.querySelector("h1");
let select = document.querySelector("select");
select.addEventListener("change",function(dets){
    h1.textContent=`${dets.target.value} is my hero`;
});

