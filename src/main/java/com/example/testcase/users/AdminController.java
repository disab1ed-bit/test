package com.example.testcase.users;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    /*
     * Список пользователей /users - доступно только для роли admin
     * Редактирование\создание пользователя /user/{id} - доступно только для роли admin
     * Редактирование\создание автора /author/{id} - доступно только для ролей admin и user
     * Редактирование\создание книги /book/{id} - доступно только для ролей admin и user
     *
     *
     * todo авторизовать методы @PreAuthorize
     * */

}
