


let searchInput = document.querySelector("#searchInput");
let addBtn =  document.querySelector("#addBtn");
let taskLeft = document.querySelector("#taskLeft");
let taskRight = document.querySelector("#taskRight");
addBtn.addEventListener("click",function(dets){
    let div = document.createElement("div");
    div.classList.add("taskCard");

    let checkBox = document.createElement("input");
    checkBox.setAttribute("type","checkbox");
    
    checkBox.classList.add("check");


    let h4 = document.createElement("h4");
    h4.classList.add("textCard");
    h4.textContent = searchInput.value;
    
    let compeleteBtn = document.createElement("input");
    compeleteBtn.setAttribute("type","button");
    compeleteBtn.setAttribute("value","Completed");
    compeleteBtn.classList.add("btn");

    


    
    compeleteBtn.addEventListener("click",function(dets){
        if(!checkBox.checked){
            alert("select the task first")
        }
        else{
            compeleteBtn.remove();

            let removeBtn = document.createElement("input");
            removeBtn.setAttribute("type","button");
            removeBtn.setAttribute("value","Remove");
            removeBtn.classList.add("btn");
            removeBtn.addEventListener("click",function(){

        
            div.remove();
       

            })
            
            div.appendChild(removeBtn);
            taskRight.appendChild(div);
            

        }
    });
    if(searchInput.value === ""){
        alert("Please Input")
    }
    else{
            div.appendChild(checkBox);
            div.appendChild(h4);
            div.appendChild(compeleteBtn);

            taskLeft.appendChild(div);
            searchInput.value = "";
    } 
});




