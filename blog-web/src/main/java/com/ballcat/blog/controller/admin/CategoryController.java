package com.ballcat.blog.controller.admin;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.validate.Update;
import com.ballcat.blog.dto.CategoryDTO;
import com.ballcat.blog.param.CategoryParam;
import com.ballcat.blog.service.CategoryService;
import com.ballcat.blog.vo.CategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:05
 * @description
 */
@RestController
@RequestMapping(value = "/admin/category")
@AllArgsConstructor
@Api(tags = "后台管理>>博客分类管理")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    @ApiOperation(value = "新增分类", httpMethod = "POST")
    public CommonResult<Integer> save(@RequestBody CategoryDTO categoryDTO) throws Exception {
        categoryService.saveBlogCategory(categoryDTO);
        return CommonResult.ok();
    }

    @PutMapping()
    @ApiOperation(value = "修改分类", httpMethod = "PUT")
    public CommonResult<Integer> update(@Validated(Update.class) @RequestBody CategoryDTO categoryDTO) throws Exception {
        categoryService.updateBlogCategory(categoryDTO);
        return CommonResult.ok();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "启用/禁用分类", httpMethod = "PUT")
    public CommonResult<Integer> enabled(@PathVariable("id") Long id, @RequestParam Boolean enabled) throws Exception {
        categoryService.enabled(id, enabled);
        return CommonResult.ok();
    }

    @GetMapping()
    @ApiOperation(value = "分类列表", httpMethod = "GET")
    public CommonResult<List<CategoryVO>> listBlogCategory(CategoryParam param) {
        return categoryService.listBlogCategory(param);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查看分类详情", httpMethod = "GET")
    public CommonResult<CategoryVO> getById(@PathVariable("id") Long id) throws BizException {
        return CommonResult.ok(categoryService.getBlogCategoryById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除分类", httpMethod = "DELETE")
    public CommonResult<Integer> removeById(@PathVariable("id") Long id) throws Exception {
        categoryService.removeCategoryById(id);
        return CommonResult.ok();
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "全部分类", httpMethod = "GET")
    public CommonResult<List<CategoryVO>> allCategory() {
        return CommonResult.ok(categoryService.allCategory());
    }
}
