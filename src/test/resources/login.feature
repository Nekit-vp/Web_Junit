Feature: Logging into site
  Logging with valid login and password. Adding some post.


  # регистрация существующего пользователя
  Example: Registration of an existing user
    When open "signUpPage" page
    And "Sign_up" page opened
    And type to input with name "login" text: "1"
    And type to input with name "password" text: "123"
    And press button with value "Create"
    Then "Sign_up" page should be opened

  # авторизация на сайте
  Example: Logging in to site
  Opening main page (you should be logged in for doing that? That's why login page would be opened).
    When open "logInPage" page
    And "Sign_in" page opened
    And type to input with name "login" text: "1"
    And type to input with name "password" text: "1"
    And press button with value "Sign_in"
    Then "Shop" page should be opened

  # добавление записи в БД
  Scenario Outline: Adding some posts
  Typing some posts in site.
    Given opened "Shop" page
    And type to input with name "text" text: "<text>"
    And type to input with name "tag" text: "<tag>"
    And press button with value "Добавить"
    Then message with tag: "<tag>" should appear
    Examples:
      | text                | tag      |
      | Ut enim ad minim    | keyboard |
      | Lorem ipsum dolor si| Lorem    |
      | Excepteur sint occa | Ex       |


  # выход с учетной записи
  Scenario: Logout
  Logout from your account. You should be redirected to login page.
    When pressed button with value "Выйти"
    Then "Sign_in" page should be opened