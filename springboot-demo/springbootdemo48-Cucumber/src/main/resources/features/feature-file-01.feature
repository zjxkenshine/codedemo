Feature: the greeting msg can be retrieved
  Scenario: client makes call to GET /greeting
    Given 名字是 "User"
    When the client calls /greeting
    Then 客户端返回码 200
    And the client receives content "Hello, User!"
