package com.example.todolist.controller; // コントローラーパッケージ

// 必要なクラスをインポート
import com.example.todolist.domain.TodoItem; // TodoItemドメインクラス
import com.example.todolist.service.TodoItemService; // TodoItemServiceサービス
import org.springframework.beans.factory.annotation.Autowired; // 依存性注入のアノテーション
import org.springframework.stereotype.Controller; // コントローラーアノテーション
import org.springframework.ui.Model; // モデルオブジェクト
import org.springframework.web.bind.annotation.GetMapping; // HTTP GETリクエストのマッピング
import org.springframework.web.bind.annotation.PathVariable; // URLパス変数のマッピング
import org.springframework.web.bind.annotation.PostMapping; // HTTP POSTリクエストのマッピング
import org.springframework.web.bind.annotation.RequestMapping; // 共通URLパスのマッピング

import java.time.LocalDate; // 日付操作用クラス
import java.util.List; // リストデータ型

// このクラスがWebアプリケーションのコントローラーであることを示す
@Controller
@RequestMapping("/todos") // "/todos"パスにマッピング
public class TodoController {

    // TodoItemServiceの自動注入
    @Autowired
    private TodoItemService todoItemService;

    // タスクリストを取得し、ビューに渡す
    @GetMapping
    public String listTodos(Model model) {
        List<TodoItem> todos = todoItemService.getAllTodoItems(); // 全タスクを取得
        model.addAttribute("todos", todos); // タスクリストをモデルに追加
        return "todoList"; // タスクリストビューを返す
    }

    // 新しいタスクのフォームを表示
    @GetMapping("/new")
    public String newTodoForm(Model model) {
        model.addAttribute("todoItem", new TodoItem()); // 新しいタスクオブジェクトを追加
        return "todoForm"; // タスク作成フォームを返す
    }

    // 新しいタスクを追加
    @PostMapping("/add")
    public String addTodo(TodoItem todoItem) {
        todoItem.setCreatedDate(LocalDate.now()); // 現在の日付を設定
        todoItemService.addTodoItem(todoItem); // 新しいタスクを保存
        return "redirect:/todos"; // タスクリストにリダイレクト
    }

    // タスクの編集フォームを表示
    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        TodoItem todoItem = todoItemService.getTodoItemById(id); // IDでタスクを検索
        if (todoItem != null) { // タスクが存在する場合
            model.addAttribute("todoItem", todoItem); // モデルにタスクを追加
            return "todoEdit"; // 編集フォームを返す
        }
        return "redirect:/todos"; // タスクリストにリダイレクト
    }

    // タスクを更新
    @PostMapping("/edit")
    public String updateTodo(TodoItem todoItem) {
        todoItemService.updateTodoItem(todoItem); // タスクを更新
        return "redirect:/todos"; // タスクリストにリダイレクト
    }

    // タスクを削除
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoItemService.deleteTodoItem(id); // タスクを削除
        return "redirect:/todos"; // タスクリストにリダイレクト
    }

    // タスクの完了状態をトグル
    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
        todoItemService.toggleCompletion(id); // 完了状態を変更
        return "redirect:/todos"; // タスクリストにリダイレクト
    }
}
