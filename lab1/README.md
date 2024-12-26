# Clothing Analysis

## Автор
Антоненко Віолетта, група ІО-25
## Контакти
[Telegram](https://t.me/xivihwa)

## Опис проєкту
Цей проєкт виконує генерацію та аналіз даних про учасників опитування на DOU. Основні функціональні можливості:

1. **Нескінченний генератор у стрімі:** створює об'єкти учасників із випадковими характеристиками, такими як ім'я, прізвище, місто проживання, дата народження та місячний дохід.
2. **Фільтрація учасників:** реалізовано кастомний Gatherer, який дозволяє пропускати задану кількість учасників із певного міста проживання.
3. **Групування учасників:** за кількістю повних років, з відбором тих, чий дохід знаходиться у вказаних межах.
4. **Статистичний аналіз доходів:** аналіз місячного доходу учасників, включаючи мінімум, максимум, середнє значення, стандартне відхилення та виявлення викидів за допомогою міжквартильного діапазону.

## Збірка та запуск

### Вимоги
- **JDK 21+**

### Інструкція зі збірки та запуску

1. Клонуйте репозиторій собі на комп'ютер:

   ```bash
   git clone https://github.com/xivihwa/java-labs.git
   ```

2. Перейдіть у директорію лабораторної роботи:

   ```bash
   cd java-labs/lab1
   ```

3. Переконайтеся, що у налаштуваннях модуля проєкту рівень мови встановлений на `preview` (для використання сучасних функцій Java).

4. Запустіть клас `Main`. Це можна зробити через командний рядок або у середовищі розробки (наприклад, IntelliJ IDEA або Eclipse).

   ```bash
   java --enable-preview -cp out Main
   ```

## Структура проєкту
- **ParticipantGenerator:** клас для генерації об'єктів учасників зі випадковими характеристиками.
- **ParticipantStatisticsCollector:** кастомний колектор для обчислення статистики місячного доходу учасників.
- **Main:** основний клас, який виконує запуск проєкту та демонстрацію його функціональності.
- **Data:** клас для зберігання статистичних даних (мінімум, максимум, середнє значення, стандартне відхилення).