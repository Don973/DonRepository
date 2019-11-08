package com.shop.web;

import com.shop.domain.CustomerVo;
import com.shop.domain.Product;

import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView=new ModelAndView();

        List<Product> productList = productService.getProductList();

        modelAndView.addObject("productList",productList);

        modelAndView.setViewName("productList");


        return modelAndView;
    }


    @RequestMapping(value = "/demo1")
    public void demo1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","wc");

//        int i=1/0;
//        System.out.println(i);



        //转发
//        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request,response);

        //重定向
//        response.sendRedirect("/WEB-INF/jsp/test.jsp");

    }


    @RequestMapping(value = "/demo2")
    public String demo2(Model model){
        model.addAttribute("name","哈哈");

        return "test";
    }

    // 转发到另一个请求
    @RequestMapping(value = "/demo3")
    public String demo3(Model model)
    {

        model.addAttribute("name","哈哈");

        return "forward:/product";
    }



    // 重定向到另一个请求
    @RequestMapping(value = "/demo4")
    public String demo4(Model model)
    {

        model.addAttribute("name","哈哈");

        return "redirect:/product";
    }


















//    @RequestMapping(value = "/itemEdit.action")
//    public ModelAndView getProductId(HttpServletRequest request){
//
//        String id = request.getParameter("id");
//
//        //根据id查询当前商品的详情
//
//        Product product = this.productService.getProductById(Integer.parseInt(id));
//
//        ModelAndView modelAndView=new ModelAndView();
//
//        modelAndView.addObject("item",product);
//        modelAndView.setViewName("productItem");
//
//        return modelAndView;
//    }


    @RequestMapping(value = "/itemEdit/{id}")
    public ModelAndView getProductId(@PathVariable("id") String id, HttpServletRequest request){

        //String id = request.getParameter("id");

        //根据id查询当前商品的详情

        Product product = this.productService.getProductById(Integer.parseInt(id));

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("item",product);
        modelAndView.setViewName("productItem");

        return modelAndView;
    }

    /**
     * 在springmvc中，默认情况下，支持类型自动转换处理
     *
     * 当前表单中input文本框虽然都是字符串类型
     *
     * 比如：price在表单中也是string
     *
     * 当时我们后台是float，我们直接使用float接收，他会自动转换
     * @return
     */
    @RequestMapping(value = "/updateitem.action")
    public ModelAndView updateitem(Product product ,MultipartFile pictureFile) throws IOException {

        //由于在dao层中入参是product对象类型，所以直接封装对象

        //product.setCreatetime(new Date());

        String originalFilename = pictureFile.getOriginalFilename();
        System.out.println(originalFilename);


        String newfilename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));

//        pictureFile.transferTo(new File("D:\\images\\"+newfilename));

        product.setPic(newfilename);

        this.productService.updateItem(product);

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.setViewName("test");

        return modelAndView;
    }

    @RequestMapping(value = "/queryitem.action")
    public ModelAndView queryitem(CustomerVo customerVo){

//        String name=customerVo.getProduct().getName();

        System.out.println("customerVo" +"``````````````"+customerVo);

        return null;
    }


    @RequestMapping(value = "/deleteAllItem.action")
    public ModelAndView deleteAllItem(CustomerVo customerVo){

        System.out.println(customerVo);

        return null;
    }

    @RequestMapping(value = "/updateAllItem.action")
    public ModelAndView updateAllItem(CustomerVo customerVo){

        System.out.println(customerVo);

        return null;
    }
}
