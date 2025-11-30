const apiUrl = "http://localhost:8080/api/tasks";

const taskForm = document.getElementById("taskForm");
const taskList = document.getElementById("taskList");

// Fetch tasks from backend
async function fetchTasks() {
    try {
        const res = await fetch(apiUrl);
        const tasks = await res.json();
        renderTasks(tasks);
    } catch (err) {
        console.error("Error fetching tasks:", err);
    }
}

// Render tasks in the list
function renderTasks(tasks) {
    taskList.innerHTML = "";
    tasks.forEach(task => {
        const li = document.createElement("li");

        li.innerHTML = `
            <span>
                ${task.title} - ${task.status} - ${task.priority} 
                ${task.dueDate ? '| Due: ' + task.dueDate : ''}
            </span>
            <span>
                <button class="btn-delete" onclick="deleteTask(${task.id})">Delete</button>
                <button class="btn-done" onclick="markDone(${task.id})">Done</button>
            </span>
        `;

        taskList.appendChild(li);
    });
}

// Add new task
taskForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const task = {
        title: document.getElementById("title").value,
        description: document.getElementById("description").value,
        priority: document.getElementById("priority").value,
        dueDate: document.getElementById("dueDate").value
    };

    try {
        await fetch(apiUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(task)
        });

        taskForm.reset();
        fetchTasks();
    } catch (err) {
        console.error("Error adding task:", err);
    }
});

// Delete task
async function deleteTask(id) {
    try {
        await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
        fetchTasks();
    } catch (err) {
        console.error("Error deleting task:", err);
    }
}

// Mark task as DONE
async function markDone(id) {
    try {
        await fetch(`${apiUrl}/${id}/status?status=DONE`, { method: "PATCH" });
        fetchTasks();
    } catch (err) {
        console.error("Error marking task as done:", err);
    }
}

// Initial fetch
fetchTasks();
