package org.lvy.mem.manager.ui;

import org.lvy.mem.manager.entity.MemCli;
import org.lvy.mem.manager.event.WindowsCloseHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by livvy on 15/8/26.
 */
public class MainForm extends BaseForm {

    private MemCli memCli;

    private JList<MemCli> lstConnections;

    private JSplitPane splitPane;

    public MainForm(MemCli memCli,int width,int height) {
        super(width, height,true);
        this.memCli = memCli;
        this.addWindowListener(new WindowsCloseHandler());

        Container container = getContentPane();
        // 创建一个滚动面板用来添加一个JTextPane
        JPanel jPanelTitle = new JPanel();
        jPanelTitle.add(new JLabel("操作"));
        JSplitPane leftAndRightPanel = new JSplitPane();

        leftAndRightPanel.setEnabled(false);
        leftAndRightPanel.setDividerSize(2);

        JScrollPane leftPanel = new JScrollPane();
        leftPanel.setLayout(new ScrollPaneLayout());
        int leftWidth = 220;
        leftPanel.setPreferredSize(new Dimension(leftWidth, height));
        leftPanel.setMinimumSize(new Dimension(leftWidth, height));
        leftPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        leftPanel.setLayout(new ScrollPaneLayout());


        lstConnections = new JList<MemCli>();
        lstConnections.setBorder(BorderFactory.createTitledBorder("所有连接"));
        MemCli[] lstData = new MemCli[]{new MemCli("localhost", "127.0.0.1", 11211),new MemCli("186", "127.0.0.1", 11211)};

        lstConnections.setListData(lstData);
        lstConnections.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MemCli value = lstConnections.getSelectedValue();
            }
        });

        leftPanel.setViewportView(lstConnections);
        leftAndRightPanel.setLeftComponent(leftPanel);

        JPanel rightPanel = new JPanel();

        rightPanel.setLayout(new GridLayout(4,2));

        rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        leftAndRightPanel.setRightComponent(rightPanel);

        leftAndRightPanel.setDividerLocation(leftWidth);
        // 创建一个垂直方向上分割的，连续布局(连续重绘)的JSplitPane，并在构造期间设置了上下组件，其中下面的组件还是一个具有默认内容的JSplitPane
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jPanelTitle,
                leftAndRightPanel);
        splitPane.setEnabled(false);
        // 设置中间分割条大小
        splitPane.setDividerSize(2);

        // 设置分割条位置
        splitPane.setDividerLocation(30);
        // 在分割条上添加小三角按钮可以实现JSplitPane左右/上下组件的快速展开或折叠。
        splitPane.setOneTouchExpandable(false);
        // 添加至内容面板
        container.add(splitPane, BorderLayout.CENTER);
    }

}
