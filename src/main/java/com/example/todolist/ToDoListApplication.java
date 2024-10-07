package com.example.todolist;

// Spring Bootで必要なクラスをインポート
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// アプリケーションのエントリポイントを示すアノテーション
@SpringBootApplication
public class ToDoListApplication {

    // Javaアプリケーションのエントリーポイント
    public static void main(String[] args) {
        // アプリケーションを起動し、組み込みWebサーバーを開始
        SpringApplication.run(ToDoListApplication.class, args);
    }
}
