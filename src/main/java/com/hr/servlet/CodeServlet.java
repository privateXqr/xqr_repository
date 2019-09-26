package com.hr.servlet;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet(name = "codeServlet", urlPatterns = {"/codeServlet"})
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 预定义图片高宽度
        int width = 100, height = 50;

        // 初始化图片
        BufferedImage img = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 初始化画笔
        Graphics2D gh = img.createGraphics();

        // 设置画笔颜色
        gh.setColor(Color.LIGHT_GRAY);
        // 填充图片
        gh.fillRect(0, 0, width - 1, height - 1);

        // 再设置画笔颜色
        gh.setColor(Color.BLACK);
        // 画边框
        gh.drawRect(0, 0, width, height);

        // ★★★★★ 生成随机数对象
        Random rd = new Random();
        // 预加载验证码字符容器
        char[] chs = "qwertyuiopasdfghjklzxcvbnm1234567890".toCharArray();
        // 验证码字符串
        String code = "";

        // 设置画笔字符串属性
        gh.setFont(new Font("微软雅黑", Font.BOLD, 40));

        // 遍历数组 随机抽取4个字符作为验证码
        for (int i = 1; i <= 4; i++) {
            char c = chs[rd.nextInt(chs.length)];
            code += c; // 拼接验证码

            // 随机设置画笔颜色
            int red = rd.nextInt(188);
            int green = rd.nextInt(188);
            int blue = rd.nextInt(188);
            Color color = new Color(red, green, blue);
            gh.setColor(color);

            // ★★★★★ 画出验证码
            gh.drawString(String.valueOf(c), i * 15, 35);
        }

        // 将最终验证码字符串传递给前台
        HttpSession session = req.getSession();
        session.setAttribute("code", code);

        // 释放画笔
        gh.dispose();

        // 生成一个字节流
        ServletOutputStream sos = resp.getOutputStream();

        // 以图片流的形式发送到前台
        ImageIO.write(img, "jpg", sos);

        // 关流
        sos.close();
    }
}
