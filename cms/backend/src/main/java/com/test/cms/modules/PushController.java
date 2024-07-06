package com.test.cms.modules;

import com.test.core.modules.dsl.conf.Push;
import com.test.core.modules.dsl.conf.PushService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/************
 * @info : QueryDsl + JpaRepository 사용 예제를 위한 RestController
 * @name : PushController
 * @date : 1/6/24 12:04 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/push/")
public class PushController {

    private final PushService service;


    // ------------- BASIC -----------------
    @ApiOperation(value = "JpaRepository - save", notes = "JpaRepository 저장")
    @PostMapping("basic/save")
    public ResponseEntity<Push> basicSave(@RequestBody Push push) {
        service.basicSave(push);
        return new ResponseEntity<>(push, HttpStatus.OK);
    }

    @ApiOperation(value = "JpaRepository - findAll", notes = "JpaRepository 전체조회")
    @GetMapping("basic/findall")
    public ResponseEntity<List<Push>> bFindAll() {
        List<Push> pushes = service.basicFind();
        return new ResponseEntity<>(pushes, HttpStatus.OK);
    }

    @ApiOperation(value = "JpaRepository - findByType", notes = "JpaRepository type 으로 조회")
    @GetMapping("basic/findbytype")
    public ResponseEntity<List<Push>> bFindByType(@RequestParam String type) {
        service.findByType(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ------------- CUSTOM -----------------
    @ApiOperation(value = "QueryDsl + JpaRepository - save", notes = "QueryDsl + JpaRepository 저장")
    @PostMapping("custom/save")
    public ResponseEntity<Push> customSave(@RequestBody Push push) {
        service.cusSave(push);
        return new ResponseEntity<>(push, HttpStatus.OK);
    }

    @ApiOperation(value = "QueryDsl + JpaRepository - findAll", notes = "QueryDsl + JpaRepository 전체조회")
    @GetMapping("custom/findall")
    public ResponseEntity<List<Push>> cFindAll() {
        List<Push> pushes = service.findCusAll();
        return new ResponseEntity<>(pushes, HttpStatus.OK);
    }

    @ApiOperation(value = "QueryDsl + JpaRepository - findByType", notes = "QueryDsl + JpaRepository type 으로 조회")
    @GetMapping("custom/findbytype")
    public ResponseEntity<List<Push>> cFindByType(@RequestParam String type) {
        List<Push> pushes = service.cusFindByType(type);
        return new ResponseEntity<>(pushes, HttpStatus.OK);
    }


}
