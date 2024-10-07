package com.example.todolist.domain; // ドメインパッケージ

import lombok.Data; // Lombokの@Dataアノテーションでgetter、setter、toStringなどを自動生成
import java.time.LocalDate; // 日付処理用のLocalDateクラス

// @Dataアノテーションで全フィールドに対するgetter、setter、toStringなどを自動生成
@Data
public class TodoItem {
    private Long id;              // タスクのユニークID
    private String task;          // タスクのタイトル
    private String content;       // タスクの内容
    private LocalDate createdDate = LocalDate.now();  // 作成日（デフォルトは現在の日付）
    private LocalDate deadline;   // 締め切り日
    private boolean completed;    // 完了状態フラグ
}
