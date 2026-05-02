let tasks = [];

function addTask() {
    const input = document.getElementById('taskInput');
    const text = input.value.trim();

    if (text === '') {
        alert('Lütfen bir görev yazın!');
        return;
    }

    const task = {
        id: Date.now(),
        text: text,
        done: false
    };

    tasks.push(task);
    input.value = '';
    renderTasks();
}

function toggleDone(id) {
    tasks = tasks.map(task =>
        task.id === id ? { ...task, done: !task.done } : task
    );
    renderTasks();
}

function deleteTask(id) {
    tasks = tasks.filter(task => task.id !== id);
    renderTasks();
}

function renderTasks() {
    const list = document.getElementById('taskList');
    list.innerHTML = '';

    if (tasks.length === 0) {
        list.innerHTML = '<li style="justify-content:center; color:#6B6B8A;">Henüz görev yok!</li>';
        return;
    }

    tasks.forEach(task => {
        const li = document.createElement('li');
        li.className = task.done ? 'done' : '';
        li.innerHTML = `
            <span>${task.text}</span>
            <div class="actions">
                <button class="done-btn" onclick="toggleDone(${task.id})">
                    ${task.done ? '↩️ Geri Al' : '✅ Tamam'}
                </button>
                <button class="delete-btn" onclick="deleteTask(${task.id})">
                    🗑️ Sil
                </button>
            </div>
        `;
        list.appendChild(li);
    });
}

// Enter tuşu ile görev ekleme
document.getElementById('taskInput').addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
        addTask();
    }
});