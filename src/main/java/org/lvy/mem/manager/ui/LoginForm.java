package org.lvy.mem.manager.ui;

import org.lvy.mem.manager.entity.MemCli;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by livvy on 15/8/25.
 */
public class LoginForm extends BaseForm{

    private JLabel lblConnName = new JLabel("name:");
    private JTextField txtConnName = new JTextField();
    private JLabel lblConnHost = new JLabel("host:");
    private JTextField txtConnHost = new JTextField();
    private JLabel lblConnPort = new JLabel("port:");
    private JTextField txtConnPort = new JTextField();

    private JButton btnAdd = new JButton("<添加");
    private JButton btnConn = new JButton("连接");

    private JList<MemCli> lstConnections;

    private JSplitPane splitPane;


    public LoginForm(final int width, final int height) {
        super(width, height);
        Container container = getContentPane();
        // 创建一个滚动面板用来添加一个JTextPane
        JPanel jPanelTitle = new JPanel();
        jPanelTitle.add(new JLabel("服务器连接设置"));
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
                txtConnHost.setText(value.getHost());
                txtConnName.setText(value.getName());
                txtConnPort.setText(Integer.toString(value.getPort()));
            }
        });

        leftPanel.setViewportView(lstConnections);
        leftAndRightPanel.setLeftComponent(leftPanel);

        JPanel rightPanel = new JPanel();

        rightPanel.setLayout(new GridLayout(4,2));
        rightPanel.add(lblConnName);
        rightPanel.add(txtConnName);
        rightPanel.add(lblConnHost);
        rightPanel.add(txtConnHost);
        rightPanel.add(lblConnPort);
        rightPanel.add(txtConnPort);
        rightPanel.add(btnAdd);
        rightPanel.add(btnConn);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                lstConnections
            }
        });

        btnConn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemCli memCli = new MemCli(txtConnName.getText(), txtConnHost.getText(), Integer.parseInt(txtConnPort.getText()));
                new MainForm(memCli,width+300,height+200).setVisible(true);
                LoginForm.this.dispose();
            }
        });
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
