# 1.Castor简介
Castor是ExoLab Group下面的一个开放源代码的项目，主要实现将java对象和XML绑定的功能，类似JAXB

# 2.绑定规则
详细规则参照官网
- http://castor.exolab.org/xml-mapping.html

1. `<mapping>`
    配置文件的根节点
    ```
    <!ELEMENT mapping ( description?, include*, class*, key-generator* )>
    ```

2. `<class>`
    定义映射的Java类
    ```
    <!ELEMENT class ( description?, cache-type?, map-to?, field+ )>
    <!ATTLIST class
              name            ID       #REQUIRED
              extends         IDREF    #IMPLIED
              depends         IDREF    #IMPLIED
              auto-complete   ( true |false ) "false"
              identity        CDATA    #IMPLIED
              access          ( read-only | shared | exclusive | db-locked )  "shared"
              key-generator   IDREF    #IMPLIED >
    ```

3. `<map-to>`
    指定根对象对应的XML节点名称，只用在根对象上
    ```
    <!ELEMENT map-to EMPTY>
    <!ATTLIST map-to
              table      NMTOKEN  #IMPLIED
              xml        NMTOKEN  #IMPLIED
              ns-uri     NMTOKEN  #IMPLIED
              ns-prefix  NMTOKEN  #IMPLIED
              ldap-dn    NMTOKEN  #IMPLIED
              ldap-oc    NMTOKEN  #IMPLIED>
    ```

4. `<field>`
    定义Java对象中需要O/X转换的属性
    ```
    <!ELEMENT field ( description?, sql?, bind-xml?, ldap? )>
    <!ATTLIST field
              name           NMTOKEN  #REQUIRED
              type           NMTOKEN  #IMPLIED
              handler        NMTOKEN  #IMPLIED
              required       ( true | false )  "false"
              direct         ( true | false )  "false"
              lazy           ( true | false )  "false"
              transient      ( true | false )  "false"
              get-method     NMTOKEN  #IMPLIED
              set-method     NMTOKEN  #IMPLIED
              create-method  NMTOKEN  #IMPLIED
              collection     ( array | vector | hashtable | collection | set | map )  #IMPLIED>
    ```

5. `<bind-xml>`
    指定Java的属性如何映射到XML文档中
    ```
    <!ELEMENT bind-xml (class?, property*)>
    <!ATTLIST bind-xml
              name     NMTOKEN     #IMPLIED
              type     NMTOKEN     #IMPLIED
              location CDATA       #IMPLIED
              matches  NMTOKENS    #IMPLIED
              QName-prefix NMTOKEN #IMPLIED
              reference   ( true | false ) "false"
              node        ( attribute | element | text )    #IMPLIED
              auto-naming ( deriveByClass | deriveByField ) #IMPLIED
              transient   ( true | false ) "false">
    ```
 