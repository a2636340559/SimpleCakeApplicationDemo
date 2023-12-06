package com.wide.cakeapplication.infrastructure.mysql.repository.menu;

import com.wide.cakeapplication.infrastructure.mysql.pojo.MenuPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuPO, Long> {
    List<MenuPO> getMenuPOSByScope(String menuScope);
}
