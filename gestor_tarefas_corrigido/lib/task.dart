class Task {
  final int? id;
  final String title;
  final String description;

  Task({this.id, required this.title, required this.description});

  Map<String, dynamic> toMap() => {
        'id': id,
        'title': title,
        'description': description,
      };

  factory Task.fromMap(Map<String, dynamic> map) => Task(
        id: map['id'],
        title: map['title'],
        description: map['description'],
      );

  Task copyWith({int? id, String? title, String? description}) => Task(
        id: id ?? this.id,
        title: title ?? this.title,
        description: description ?? this.description,
      );
}
