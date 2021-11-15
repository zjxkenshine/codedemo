# 1.GraphQL简介
- GraphQL是一种针对图状数据进行查询特别有优势的查询语言，Facebook开发的
- 给客户端筛选自由获取服务端事先定义好的数据，提高了交互接口的灵活性(前端自由挑选要返回的数据)
- 至今没有火起来，在前端后端中间加了一层，太过理想化

# 2.可视化工具
- graphiql
- graphql-voyager

# 3.概念
- Schema：完整描述了客户端可以访问的所有数据（对象、成员变量、关系、任何类型）
- Field：可以从对象中获取的数据单元
- Argument：附加在特定field后面的一组键值对
- Implementation：schema可以使用implement定义对象继承于哪个接口
- Connection：能在同一个请求中查询关联的对象
- Edge：edge表示node之间的connection，每个edgesfield都有一个nodefield和一个cursorfield。cursor是用来分页的
- Node：对象的一个泛型，可以直接查询一个node，也可以通过connection获取相关node

# 4.基本使用
1. 查询__schema以列出所有该schema中定义的类型，并获取每一个的细节：
    ```
    query {
      __schema {
        types {
          name
          kind
          description
          fields {
            name
          }
        }
      }
    }
    ```
2. 查询__type以获取任意类型的细节：
    ```
    query {
      __type(name: "Repository") {
        name
        kind
        description
        fields {
          name
        }
      }
    }
    ```
3. 关于 query 和 mutation 操作:
    - query操作类似GET请求，mutation操作类似POST/PATCH/DELETE
    - query: GraphQL query只会返回你指定的data
        ```
        query {
          JSON objects to return
        }
        ```
     - 建立一个mutation，你必须指定三样东西:
        - mutation name：你想要执行的修改类型
        - input object：你想要传递给服务器的数据，由input field组成
        - payload object：你想要服务器返回给你的数据，由return field组成
       ```
        mutation {
          mutationName(input: {MutationNameInput!}) {
            MutationNamePayload
        }
       ```
4. variables：使query更动态更强大，同时他能简化mutation input object的传值
    ```
   query($number_of_repos:Int!) {
     viewer {
       name
        repositories(last: $number_of_repos) {
          nodes {
            name
          }
        }
      }
   }
   variables {
      "number_of_repos": 3
   }
    ```
   使用variables分为三步:
   - 在操作外通过一个variables对象定义变量
   - 将变量作为argument传入操作(Int!表示必须是int类型)
   - 在操作中使用变量




