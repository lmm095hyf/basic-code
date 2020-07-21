package cn.java.day27;
/**
 * java 桌面编程
 * 1.Swing jdk 提供（官方）  ==>基于Java虚拟机实现
 * 2.SWT eclipse 提供（IBM） ==>基于操作系统本地的图形接口
 *
 * 第一次课内容：
 * 1.基本SWT控件的使用  简单界面
 * 2.定义用户响应的事件
 * 3.基本的布局控件
 * 第二次课内容：
 * 1.高级控件（表格，菜单，tab标签）
 * 2.窗口传参
 *
 * 登录窗口
 *
 * 控件分类
 * 1.Composites：*容器控件（用于放置其他控件的控件）
 * 2.Layout：   *布局控件（用于定位控件位置的控件）
 * 3.controls： *基本控件，文本框，按钮
 * 4.JFace：    其他框架控件
 * 5.Forms API：表单控件（用于数据表单提交）
 * 6.Menu：    *菜单
 *
 * SWT的布局控件，加在容器控件上面
 *
 *  1. 绝对布局
 *  2. Fill 填充布局
 *  3. Stack 卡片布局, 每一个控件就是一个卡片, 所有卡片叠在一起, 一次只能看到一个
 *  4. row  行布局
 *  5. form 表单布局
 *
 *  Java的图形开发技术
 *      swing 官方提供的  基于Java虚拟机  跨平台性
 *      SWT  eclipse 提供的图形开发包  基于操作系统 性能高
 *
 * shell  窗体  ===>Display对象负责调用操作系统的图形接口
 * Label： 文本标签（静态）
 * Text：  文本输入框
 * Button： 按钮（有多种形态），在构建时（new）传入不同的类型参数，
 *          就会构建出不同的按钮（多选框，单选框，按钮。。。。）
 *
 * 容器控件：内部可以放置其他控件的控件，Composite
 *
 *
 */
public class Demo {
}