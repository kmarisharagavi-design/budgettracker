const API_URL = "http://localhost:8080/expense";

async function addExpense() {

    const expense = {
        amount: document.getElementById("amount").value,
        category: document.getElementById("category").value,
        description: document.getElementById("description").value
    };

    await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(expense)
    });

    loadExpenses();
}

async function loadExpenses() {

    const response = await fetch(API_URL);
    const data = await response.json();

    let rows = "";

    data.forEach(expense => {
        rows += `
        <tr>
            <td>${expense.id}</td>
            <td>${expense.amount}</td>
            <td>${expense.category}</td>
            <td>${expense.description}</td>
        </tr>
        `;
    });

    document.getElementById("expenseTable").innerHTML = rows;
}

loadExpenses();