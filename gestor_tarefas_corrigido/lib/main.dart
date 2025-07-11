import 'package:flutter/material.dart';
import 'task.dart';
import 'task_database.dart';
import 'add_task_screen.dart';

void main() {
  runApp(TaskManagerApp());
}

class TaskManagerApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Task Manager',
      theme: ThemeData(
        primaryColor: Colors.deepPurple,
        scaffoldBackgroundColor: Colors.grey[100],
        appBarTheme: AppBarTheme(
          backgroundColor: Colors.deepPurple,
          foregroundColor: Colors.white,
        ),
        floatingActionButtonTheme: FloatingActionButtonThemeData(
          backgroundColor: Colors.blueAccent,
        ),
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.blueAccent,
          ),
        ),
      ),
      home: TaskListScreen(),
    );
  }
}

class TaskListScreen extends StatefulWidget {
  @override
  _TaskListScreenState createState() => _TaskListScreenState();
}

class _TaskListScreenState extends State<TaskListScreen> {
  List<Task> tasks = [];

  @override
  void initState() {
    super.initState();
    _loadTasks();
  }

  Future<void> _loadTasks() async {
    final loadedTasks = await TaskDatabase.instance.readAllTasks();
    setState(() => tasks = loadedTasks);
  }

  Future<void> _addTask(Task task) async {
    final newTask = await TaskDatabase.instance.create(task);
    setState(() => tasks.add(newTask));
  }

  Future<void> _removeTask(int index) async {
    final task = tasks[index];
    final confirm = await _showDeleteConfirmation(task.title);
    if (confirm) {
      await TaskDatabase.instance.delete(task.id!);
      setState(() => tasks.removeAt(index));
    }
  }

  Future<bool> _showDeleteConfirmation(String title) async {
    return await showDialog<bool>(
          context: context,
          builder: (context) => AlertDialog(
            title: Text('Excluir Tarefa'),
            content: Text('Deseja realmente excluir "$title"?'),
            actions: [
              TextButton(
                child: Text('Cancelar'),
                onPressed: () => Navigator.of(context).pop(false),
              ),
              TextButton(
                child: Text('Excluir', style: TextStyle(color: Colors.red)),
                onPressed: () => Navigator.of(context).pop(true),
              ),
            ],
          ),
        ) ??
        false;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Tarefas Prioritárias')),
      body: ReorderableListView(
        onReorder: (oldIndex, newIndex) {
          setState(() {
            if (newIndex > oldIndex) newIndex -= 1;
            final Task item = tasks.removeAt(oldIndex);
            tasks.insert(newIndex, item);
          });
        },
        children: [
          for (int i = 0; i < tasks.length; i++)
            ListTile(
              key: ValueKey(tasks[i].id),
              title: Text(tasks[i].title),
              subtitle: Text(tasks[i].description),
              leading: Icon(Icons.drag_handle),
              trailing: IconButton(
                icon: Icon(Icons.delete, color: Colors.red),
                onPressed: () => _removeTask(i),
              ),
            ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          final Task? newTask = await Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => AddTaskScreen()),
          );
          if (newTask != null) await _addTask(newTask);
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
