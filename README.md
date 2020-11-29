# RentaTeamTestWork

Техническое задание тестового приложения

Необходимо написать приложение, позволяющее получать данные с сервера (ссылка ниже по тексту), корректно обрабатывать и выводить данные на экран для удобного представления пользователю.
Приложение состоит из трех экранов:
    1 Экран со списком пользователей
    2 Экран “О программе”
    3 Экран карточки пользователя
	Переход между первыми двумя экранами осуществляется при помощи нижнего навигационного меню (реализовать подход Single Activity App).
    1 Экран со списком пользователей:
    • На этом экране, должна происходить загрузка списка пользователей. Должен присутствовать индикатор загрузки. После загрузки должен отображаться список пользователей, каждый элемент списка должен состоять из Имени и Фамилии пользователя. В случае, если загрузка по каким-то причинам не удалась, требуется оповестить об этом пользователя.
    • По клику на элемент списка должен открываться экран карточки пользователя. В карточке пользователя должен отображаться аватар пользователя, его фамилия и имя, а так же email
    2 Экран “О программе” содержит текст “Тестовое задание для Rentateam”

https://reqres.in/api/users - get метод, возвращающий список пользователей

Требования к приложению:
    • Язык для написания приложения Kotlin/Java (предпочтительнее Kotlin).
    • Использовать архитектуру MVP или MVVM на выбор. Для MVP можно использовать библиотеку moxy.
    • Должен быть предусмотрен оффлайн режим. Выбор БД для кэширования на усмотрение соискателя.
    • Использовать Retrofit для запросов к серверу
    • Использовать RxJava2 при асинхронных запросах к БД и серверу
    • Использовать Picasso или Glide для работы с изображениями
    • Плюсом будет использование di (Dagger 2)
    • Дизайн произвольный, главное корректное отображение требуемых данных.
    • MinSdkVersion = 19, ориентация экрана “portrait”

В качестве результата выполнения задания высылайте на почту serafima@rentateam.ru (Копия dmitriy.shin@rentateam.ru artem.plut@rentateam.ru 
nikita.drozzin@rentateam.ru)
Subj: Тестовое задание Android от %%
    1 ссылку на исходники в github
    2 затраченное время на задачу (в часах)
    3 ссылку на ваше резюме

