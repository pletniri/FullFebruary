
async function getEmployee(){
    const elem = document.getElementById("list-items");
    try {
        const response = await fetch('http://localhost:8080/api/employee');
        const responseJSO = await response.json();
        elem.innerText = `The next employee is ${responseJSO[0].name} and the position is ${responseJSO[0].position}`;

    } catch (e) {
        console.log(e);
    }
}

getEmployee();