# Todo Application (CI/CD Практическая работа №2)

[![CI / Build & Release](https://github.com/romaxaa/todo-app/actions/workflows/ci.yml/badge.svg)](https://github.com/romaxaa/todo-app/actions/workflows/ci.yml)
[![Publish to GitHub Packages (Maven)](https://github.com/romaxaa/todo-app/actions/workflows/publish-package.yml/badge.svg)](https://github.com/romaxaa/todo-app/actions/workflows/publish-package.yml)
[![Nightly Build & Test](https://github.com/romaxaa/todo-app/actions/workflows/nightly.yml/badge.svg)](https://github.com/romaxaa/todo-app/actions/workflows/nightly.yml)

Консольное приложение Todo App на Java с автоматизированным CI/CD пайплайном, разработанное по методологии **GitHub Flow**.

## Ссылки проекта
- **GitHub Actions (CI/CD):** [https://github.com/romaxaa/todo-app/actions](https://github.com/romaxaa/todo-app/actions)
- **GitHub Releases:** [https://github.com/romaxaa/todo-app/releases](https://github.com/romaxaa/todo-app/releases)
- **GitHub Packages (Maven):** [https://github.com/romaxaa/todo-app/packages](https://github.com/romaxaa/todo-app/packages)

---

## Возможности приложения
- `add <task>` — добавление новой задачи.
- `remove <index>` — удаление задачи по индексу.
- `done <index>` — отметка задачи как выполненной (`[DONE]`).
- `search <query>` — поиск задач по подстроке.
- `clear` — очистка всего списка задач.
- `list` — вывод всех текущих задач.
- `exit` — выход из приложения.

---

## Архитектура CI/CD
1. **GitHub Flow**: разработка велась через изолированные ветки (`feat/todo-app-implementation`, `feat/actions`) и Pull Requests в `main`.
2. **CI / Build & Release (`ci.yml`)**:
   - Автоматический триггер при push/merge в ветку `main`.
   - Запуск тестов JUnit 5 (`./gradlew test`).
   - Сборка fat-JAR (Shadow plugin).
   - Создание нового GitHub Release с прикреплением исполняемого JAR-артефакта.
3. **CD / Publish to GitHub Packages (`publish-package.yml`)**:
   - Триггер `workflow_run` после успешного завершения `CI / Build & Release`.
   - Публикация артефакта в реестр пакетов GitHub Packages (Maven).
4. **Nightly CI (`nightly.yml`)**:
   - Сборка по cron-расписанию (`0 2 * * *`) для проверки стабильности ветки `main`.

---

## Запуск приложения
Скачайте готовый `todo-app-<version>.jar` из раздела [Releases](https://github.com/romaxaa/todo-app/releases) и выполните:
```bash
java -jar todo-app-0.1.0.jar
```
