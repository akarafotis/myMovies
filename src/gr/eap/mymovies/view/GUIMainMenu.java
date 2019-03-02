package gr.eap.mymovies.view;

import gr.eap.mymovies.controller.ControllerMovie;
import gr.eap.mymovies.controller.ControllerGenre;
import gr.eap.mymovies.controller.ControllerFavoriteList;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.model.FavoriteList;
import gr.eap.mymovies.model.Genre;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
public class GUIMainMenu extends javax.swing.JFrame {

    private final ControllerMovie controllerMovie;
    private final ControllerGenre controllerGenre;
    private final ControllerFavoriteList controllerFavoriteList;
    private FavoriteList selectedFL;
    private List<FavoriteList> lists;
    private String movieTitle = "";

    public GUIMainMenu() {
        initComponents();
        // emfanish tou parthirou sto kentro tis othonis
        this.setLocationRelativeTo(null);
        // arxika ta ComboBox den exoun timh
        genreComboBox.setSelectedIndex(-1);
        favoriteListComboBox.setSelectedIndex(-1);
        // apokripsh olon ton kentrikwn panels
        LayeredPane.removeAll();
        // prosthiki tou aboutPanel
        LayeredPane.add(aboutPanel);
        // apokripsh olon ton eswterikwn panels
        top10Panel.setVisible(false);
        topPerListPanel.setVisible(false);
        searchTablePanel.setVisible(false);
        favoriteListMoviesPanel.setVisible(false);
        // arxikopoihsh Application Controller
        controllerMovie = new ControllerMovie();
        controllerGenre = new ControllerGenre();
        controllerFavoriteList = new ControllerFavoriteList();
        // metonomasia Buttons Text
        UIManager.put("OptionPane.cancelButtonText", "Ακύρωση");
        UIManager.put("OptionPane.okButtonText", "OK");
        // katallilo tooltip gia to yearLabel
        yearLabel.setToolTipText("2000 έως το τρέχον έτος (ΥΥΥΥ)");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        myMoviesPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMoviesPU").createEntityManager();
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : myMoviesPUEntityManager.createQuery("SELECT f.name FROM FavoriteList f");
        genreQuery = java.beans.Beans.isDesignTime() ? null : myMoviesPUEntityManager.createQuery("SELECT g.name FROM Genre g");
        favoriteListsQuery = java.beans.Beans.isDesignTime() ? null : myMoviesPUEntityManager.createQuery("SELECT f.name FROM FavoriteList f");
        favoriteListQuery1 = java.beans.Beans.isDesignTime() ? null : myMoviesPUEntityManager.createQuery("SELECT f.name FROM FavoriteList f");
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : favoriteListQuery1.getResultList();
        favoriteListQuery2 = java.beans.Beans.isDesignTime() ? null : myMoviesPUEntityManager.createQuery("SELECT f.name FROM FavoriteList f");
        favoriteListList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : favoriteListQuery2.getResultList();
        buttonsPanel = new javax.swing.JPanel();
        retrieveAndStoreMovies = new javax.swing.JButton();
        manageFavoriteLists = new javax.swing.JButton();
        searchMovies = new javax.swing.JButton();
        statistics = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        LayeredPane = new javax.swing.JLayeredPane();
        progressPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        statsPanel = new javax.swing.JPanel();
        top10Button = new javax.swing.JButton();
        topPerListButton = new javax.swing.JButton();
        top10Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        top10Table = new javax.swing.JTable();
        topPerListPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        topPerListTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        favoriteListsPanel = new javax.swing.JPanel();
        favoriteListMoviesPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        favoriteListMoviesTable = new javax.swing.JTable();
        createButtonFL = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        favoritListList = new javax.swing.JList<>();
        updateButtonFL = new javax.swing.JButton();
        deleteButtonFL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        searchPanel = new javax.swing.JPanel();
        searchTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        favoriteMoviesTable = new javax.swing.JTable();
        addtoListLabel = new javax.swing.JLabel();
        favoriteListComboBox = new javax.swing.JComboBox<>();
        removeFromListButton = new javax.swing.JButton();
        genreComboBox = new javax.swing.JComboBox<>();
        yearTextField = new javax.swing.JTextField();
        selectGenreLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        searchMoviesLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        aboutPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        abouttext = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MoviesMenu = new javax.swing.JMenu();
        retrieveAndStoreMoviesSubMenu = new javax.swing.JMenuItem();
        searchMoviesSubMenu = new javax.swing.JMenuItem();
        moviesListsMenu = new javax.swing.JMenu();
        manageFavoriteListsSubMenu = new javax.swing.JMenuItem();
        statisticsMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("myMovies");
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMainMenu.class.getResource("movies.png")));
        setMinimumSize(new java.awt.Dimension(1030, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        buttonsPanel.setPreferredSize(new java.awt.Dimension(1050, 99));

        retrieveAndStoreMovies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/restore.png"))); // NOI18N
        retrieveAndStoreMovies.setText("<html><center>Ανάκτηση &<br/>Αποθήκευση<br/>Δεδομένων Ταινιών</center></html>");
        retrieveAndStoreMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveAndStoreMoviesActionPerformed(evt);
            }
        });

        manageFavoriteLists.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/manageLists.png"))); // NOI18N
        manageFavoriteLists.setText("<html><center>Διαχείριση Λιστών <br/>Αγαπημένων Ταινιών</center></html>");
        manageFavoriteLists.setToolTipText("");
        manageFavoriteLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageFavoriteListsActionPerformed(evt);
            }
        });

        searchMovies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/searchMovie.png"))); // NOI18N
        searchMovies.setText("<html><center>Αναζήτηση<br/>Ταινιών</center></html>");
        searchMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMovies(evt);
            }
        });

        statistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/statMovies.png"))); // NOI18N
        statistics.setText("Στατιστικά");
        statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispalyStats(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/exit.png"))); // NOI18N
        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(retrieveAndStoreMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageFavoriteLists, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retrieveAndStoreMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(manageFavoriteLists, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(buttonsPanel);
        buttonsPanel.setBounds(0, 0, 1024, 99);
        buttonsPanel.getAccessibleContext().setAccessibleName("ButtonPanel");

        progressPanel.setPreferredSize(new java.awt.Dimension(1035, 620));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/ajax-loader.gif"))); // NOI18N

        jLabel6.setText("Η ανάκτηση των δεδομένων είναι σε εξέλιξη");

        jLabel14.setText("Παρακαλώ περιμένετε");

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressPanelLayout.createSequentialGroup()
                .addGap(49, 401, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addGroup(progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(progressPanelLayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel5))
                    .addGroup(progressPanelLayout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        statsPanel.setPreferredSize(new java.awt.Dimension(1035, 620));

        top10Button.setText("Οι Καλύτερες 10 Ταινίες");
        top10Button.setMaximumSize(new java.awt.Dimension(179, 39));
        top10Button.setMinimumSize(new java.awt.Dimension(179, 39));
        top10Button.setOpaque(false);
        top10Button.setPreferredSize(new java.awt.Dimension(179, 39));
        top10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top10ButtonActionPerformed(evt);
            }
        });

        topPerListButton.setText("Οι Καλύτερες Ταινίες ανά Λίστα");
        topPerListButton.setMaximumSize(new java.awt.Dimension(217, 39));
        topPerListButton.setMinimumSize(new java.awt.Dimension(217, 39));
        topPerListButton.setPreferredSize(new java.awt.Dimension(217, 39));
        topPerListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topPerListButtonActionPerformed(evt);
            }
        });

        top10Table.setBackground(new java.awt.Color(240, 240, 240));
        top10Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Όνομα ταινίας", "Βαθμολογία"
            }
        ));
        top10Table.setEnabled(false);
        jScrollPane1.setViewportView(top10Table);

        javax.swing.GroupLayout top10PanelLayout = new javax.swing.GroupLayout(top10Panel);
        top10Panel.setLayout(top10PanelLayout);
        top10PanelLayout.setHorizontalGroup(
            top10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, top10PanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        top10PanelLayout.setVerticalGroup(
            top10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top10PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        topPerListTable.setBackground(new java.awt.Color(240, 240, 240));
        topPerListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Όνομα ταινίας", "Λίστα Αγαπημένων"
            }
        ));
        topPerListTable.setEnabled(false);
        jScrollPane3.setViewportView(topPerListTable);

        javax.swing.GroupLayout topPerListPanelLayout = new javax.swing.GroupLayout(topPerListPanel);
        topPerListPanel.setLayout(topPerListPanelLayout);
        topPerListPanelLayout.setHorizontalGroup(
            topPerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPerListPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        topPerListPanelLayout.setVerticalGroup(
            topPerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPerListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/top.png"))); // NOI18N

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(top10Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(topPerListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(top10Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(topPerListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(top10Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(topPerListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(top10Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topPerListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favoriteListsPanel.setPreferredSize(new java.awt.Dimension(1035, 620));

        favoriteListMoviesTable.setBackground(new java.awt.Color(240, 240, 240));
        favoriteListMoviesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Τίτλος ταινίας", "Βαθμολογία", "Περιγραφή"
            }
        ));
        favoriteListMoviesTable.setEnabled(false);
        jScrollPane5.setViewportView(favoriteListMoviesTable);

        javax.swing.GroupLayout favoriteListMoviesPanelLayout = new javax.swing.GroupLayout(favoriteListMoviesPanel);
        favoriteListMoviesPanel.setLayout(favoriteListMoviesPanelLayout);
        favoriteListMoviesPanelLayout.setHorizontalGroup(
            favoriteListMoviesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoriteListMoviesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        favoriteListMoviesPanelLayout.setVerticalGroup(
            favoriteListMoviesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoriteListMoviesPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        createButtonFL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/new.png"))); // NOI18N
        createButtonFL.setText("Δημιουργία");
        createButtonFL.setToolTipText("");
        createButtonFL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonFLMouseClicked(evt);
            }
        });

        favoritListList.setBackground(new java.awt.Color(240, 240, 240));
        favoritListList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                favoritListListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(favoritListList);

        updateButtonFL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/edit.png"))); // NOI18N
        updateButtonFL.setLabel("Επεξεργασία");
        updateButtonFL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonFLMouseClicked(evt);
            }
        });

        deleteButtonFL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/delete.png"))); // NOI18N
        deleteButtonFL.setText("   Διαγραφή");
        deleteButtonFL.setToolTipText("");
        deleteButtonFL.setMaximumSize(new java.awt.Dimension(131, 39));
        deleteButtonFL.setMinimumSize(new java.awt.Dimension(131, 39));
        deleteButtonFL.setPreferredSize(new java.awt.Dimension(131, 39));
        deleteButtonFL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonFLActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Λίστες Αγαπημένων");

        javax.swing.GroupLayout favoriteListsPanelLayout = new javax.swing.GroupLayout(favoriteListsPanel);
        favoriteListsPanel.setLayout(favoriteListsPanelLayout);
        favoriteListsPanelLayout.setHorizontalGroup(
            favoriteListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoriteListsPanelLayout.createSequentialGroup()
                .addGroup(favoriteListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(favoriteListsPanelLayout.createSequentialGroup()
                        .addGroup(favoriteListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(favoriteListsPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, favoriteListsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(favoriteListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(updateButtonFL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteButtonFL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createButtonFL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(favoriteListMoviesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(favoriteListsPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        favoriteListsPanelLayout.setVerticalGroup(
            favoriteListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoriteListsPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(favoriteListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(favoriteListsPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(createButtonFL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButtonFL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButtonFL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(favoriteListMoviesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        deleteButtonFL.getAccessibleContext().setAccessibleName("Διαγραφή");

        searchPanel.setMinimumSize(new java.awt.Dimension(1035, 620));
        searchPanel.setPreferredSize(new java.awt.Dimension(1035, 620));

        favoriteMoviesTable.setAutoCreateRowSorter(true);
        favoriteMoviesTable.setBackground(new java.awt.Color(240, 240, 240));
        favoriteMoviesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Τίτλος ταινίας", "Βαθμολογία", "Περιγραφή"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        favoriteMoviesTable.setShowVerticalLines(false);
        favoriteMoviesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favoriteMoviesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(favoriteMoviesTable);

        addtoListLabel.setText("Προσθήκη σε Λίστα");
        addtoListLabel.setOpaque(true);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${resultList}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListQuery, eLProperty, favoriteListComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        favoriteListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteListComboBoxActionPerformed(evt);
            }
        });

        removeFromListButton.setText("Αφαίρεση από Λίστα");
        removeFromListButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeFromListButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout searchTablePanelLayout = new javax.swing.GroupLayout(searchTablePanel);
        searchTablePanel.setLayout(searchTablePanelLayout);
        searchTablePanelLayout.setHorizontalGroup(
            searchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTablePanelLayout.createSequentialGroup()
                .addGroup(searchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchTablePanelLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(addtoListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(favoriteListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(removeFromListButton))
                    .addGroup(searchTablePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        searchTablePanelLayout.setVerticalGroup(
            searchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addtoListLabel)
                    .addComponent(favoriteListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeFromListButton))
                .addGap(29, 29, 29))
        );

        genreComboBox.setBackground(new java.awt.Color(240, 240, 240));
        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${resultList}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, genreQuery, eLProperty, genreComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        yearTextField.setBackground(new java.awt.Color(240, 240, 240));

        selectGenreLabel.setText("Επιλέξτε είδος");

        yearLabel.setText("Έτος Κυκλοφορίας");

        searchMoviesLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchMoviesLabel.setText("Αναζήτηση Ταινιών");

        searchButton.setText("Αναζήτηση");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Καθαρισμός Κριτηρίων");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(searchMoviesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchButton)
                        .addGap(72, 72, 72)
                        .addComponent(clearButton))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectGenreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genreComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(searchTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(searchMoviesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectGenreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yearTextField)
                    .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(471, 471, 471))
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aboutPanel.setPreferredSize(new java.awt.Dimension(1035, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/movies.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("myMovies");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Product Owner:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Γεώργιος Μανής");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Scrum Team:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Ευθύμιος Γεωργάκης");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Κυριάκος Καγιαλόγλου");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Αριστείδης Καραφώτης");

        abouttext.setEditable(false);
        abouttext.setBackground(new java.awt.Color(240, 240, 240));
        abouttext.setColumns(20);
        abouttext.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        abouttext.setRows(4);
        abouttext.setText("H εφαρμογή \"myMovies\" υλοποιήθηκε στo πλαίσιo της 3ης γραπτής εργασίας της  Θ.Ε ΠΛΗ24 του ΕΑΠ για το έτος 2018-2019\n\n");
        abouttext.setWrapStyleWord(true);
        abouttext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane6.setViewportView(abouttext);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/eap.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Άγγελος Λένας");

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(aboutPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(212, 212, 212))
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        aboutPanelLayout.setVerticalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(aboutPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12))
                    .addGroup(aboutPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        LayeredPane.setLayer(progressPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayeredPane.setLayer(statsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayeredPane.setLayer(favoriteListsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayeredPane.setLayer(searchPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayeredPane.setLayer(aboutPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayeredPaneLayout = new javax.swing.GroupLayout(LayeredPane);
        LayeredPane.setLayout(LayeredPaneLayout);
        LayeredPaneLayout.setHorizontalGroup(
            LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addComponent(favoriteListsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addComponent(statsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 4, Short.MAX_VALUE)))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(aboutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        LayeredPaneLayout.setVerticalGroup(
            LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LayeredPaneLayout.createSequentialGroup()
                    .addComponent(favoriteListsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(statsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(aboutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(LayeredPane);
        LayeredPane.setBounds(0, 110, 1030, 630);

        MoviesMenu.setText("Ταινίες");

        retrieveAndStoreMoviesSubMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        retrieveAndStoreMoviesSubMenu.setText("Ανάκτηση και Αποθήκευση Δεδομένων Ταινιών");
        retrieveAndStoreMoviesSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveAndStoreMoviesSubMenuActionPerformed(evt);
            }
        });
        MoviesMenu.add(retrieveAndStoreMoviesSubMenu);

        searchMoviesSubMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        searchMoviesSubMenu.setText("Αναζήτηση Ταινιών");
        searchMoviesSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMoviesSubMenuActionPerformed(evt);
            }
        });
        MoviesMenu.add(searchMoviesSubMenu);

        MenuBar.add(MoviesMenu);
        MoviesMenu.getAccessibleContext().setAccessibleDescription("");

        moviesListsMenu.setText("Λίστες Ταινιών");

        manageFavoriteListsSubMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        manageFavoriteListsSubMenu.setText("Διαχείριση Λιστών Αγαπημένων Ταινιών");
        manageFavoriteListsSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageFavoriteListsSubMenuActionPerformed(evt);
            }
        });
        moviesListsMenu.add(manageFavoriteListsSubMenu);

        MenuBar.add(moviesListsMenu);

        statisticsMenu.setText("Στατιστικά");
        statisticsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statisticsMenuMouseClicked(evt);
            }
        });
        MenuBar.add(statisticsMenu);

        aboutMenu.setText("Σχετικά");
        aboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuMouseClicked(evt);
            }
        });
        MenuBar.add(aboutMenu);

        exitMenu.setText("Έξοδος");
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuMouseClicked(evt);
            }
        });
        MenuBar.add(exitMenu);

        setJMenuBar(MenuBar);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // methodos gia anaktish kai apothikeush tainiwn
    private void retrieveAndStoreMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveAndStoreMoviesActionPerformed
        Object[] options = {"Ναι", "Ακύρωση"};
        int n = JOptionPane.showOptionDialog(null,
                "Η ανάκτηση δεδομένων θα διαγράψει όλες τις ταινίες και τις λίστες σας. Είστε σίγουρος?" + "\n",
                "Προειδοποίηση",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        if (n == JOptionPane.YES_OPTION) {
            // efoson epibebaiwsei o xrhsths emfanizetai to katallhlo panel
            LayeredPane.removeAll();
            LayeredPane.add(progressPanel);
            progressPanel.setVisible(true);
            // ekteleite h anaktish mesw tou TaskInitialize
            // wste na mhn "pagwsei" h efarmogi
            new TaskInitialize().execute();
        }
    }//GEN-LAST:event_retrieveAndStoreMoviesActionPerformed

    // methodos gia th diaxeirish twn listwn
    private void manageFavoriteListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageFavoriteListsActionPerformed
        switchPanels(favoriteListsPanel); // emfanish tou katallilou panel
        favoriteListMoviesPanel.setVisible(false); // apokripsh tou pinaka tainiwv tis FavoriteList
        drawFL(); // epanafora tvn listvn se periptvsh poy exoyn allaksei
    }//GEN-LAST:event_manageFavoriteListsActionPerformed

    // methodos gia thn eksodo apo thn efarmogh
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    // methodos gia thn anazitisi tainiwn
    private void searchMovies(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMovies
        switchPanels(searchPanel); // emfanish tou katallilou panel
        fetchGenres(); // epanafora tvn eidwn se periptvsh poy exoyn allaksei
        // adeiazoyme tis times tou eidous,etous kai krivoume to panel
        genreComboBox.setSelectedIndex(-1);
        yearTextField.setText("");
        searchTablePanel.setVisible(false);
    }//GEN-LAST:event_searchMovies

    // methodos gia thn emfanisi statistikwn
    private void dispalyStats(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispalyStats
        switchPanels(statsPanel); // emfanish tou katallilou panel
        // apokripsi twn eswterikwn panels
        top10Panel.setVisible(false);
        topPerListPanel.setVisible(false);
    }//GEN-LAST:event_dispalyStats

    // methodos gia thn diaxeirisi twn listvn apo to menu
    private void manageFavoriteListsSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageFavoriteListsSubMenuActionPerformed
        manageFavoriteListsActionPerformed(evt); // klisi ths katallilis methodou
    }//GEN-LAST:event_manageFavoriteListsSubMenuActionPerformed

    // methodos gia thn prosthiki mias tainias se mia favoriteList agapimenwn
    // mesw tou favoriteListComboBox
    private void favoriteListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteListComboBoxActionPerformed
        // an exei epilegei timh apo to favoriteListComboBox
        if (favoriteListComboBox.getSelectedItem() != null && movieTitle != "") {
            // kratame thn epilegmenh timh se String
            String selectedFavoriteList = (String) favoriteListComboBox.getSelectedItem();
            if (selectedFavoriteList == null || movieTitle == "") {
                JOptionPane.showMessageDialog(this, "Πρέπει να επιλέξετε μια ταινία και μια λιστα");
            } else {
                // vriskoume tin FavoriteList vasei onomatos
                List<FavoriteList> list = controllerFavoriteList.selectFL(selectedFavoriteList);
                FavoriteList fl = list.get(0);
                // vriskoume tin tainia vasei onomatos
                List<Movie> selectedMovies = controllerMovie.selectMovie(movieTitle);
                Movie m = selectedMovies.get(0);
                try {
                    if (m.getFavoriteListId() == null) {
                        controllerMovie.updateMovie(m, fl);
                        JOptionPane.showMessageDialog(this, "Η ταινία " + m.getTitle() + " προστέθηκε στη λίστα Αγαπημένων:\n " + fl.getName());
                    } else if (m.getFavoriteListId().getId() != fl.getId()) {
                        controllerMovie.updateMovie(m, fl);
                        JOptionPane.showMessageDialog(this, "Η ταινία " + m.getTitle() + " προστέθηκε στη λίστα Αγαπημένων:\n " + fl.getName());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GUIMainMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(GUIMainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_favoriteListComboBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        movieTitle = "";
        fetchFL();
        favoriteListComboBox.setSelectedIndex(-1);
        String selectedGenre = (String) genreComboBox.getSelectedItem();
        String year = yearTextField.getText();

        try {
            int k = Integer.parseInt(yearTextField.getText());

        } catch (Exception z) {
            JOptionPane.showMessageDialog(this, "Στο πεδίο Έτος Κυκλοφορίας πρέπει να εισάγετε 4  αριθμητικά ψηφία",
                    "Λάθος Καταχώρηση", JOptionPane.ERROR_MESSAGE);
            yearTextField.setText("");
            return;
        }

        if ((int) (Math.log10(Integer.parseInt(yearTextField.getText())) + 1) != 4) {
            JOptionPane.showMessageDialog(this, "Το πεδίο έτος αποτελείται από 4 ψηφία");
        } else if (genreComboBox.getSelectedItem() == null || yearTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Πρέπει να συμπληρώσετε το έτος και το είδος");
        } else {
            favoriteMoviesTable.setVisible(true);
            System.out.println("ok");
            List<Movie> filteredMovies = controllerMovie.searchMovies(selectedGenre, year);
            if (filteredMovies.size() == 0) {
                searchTablePanel.setVisible(false);
                JOptionPane.showMessageDialog(this, "Δεν βρέθηκε ταινία με αυτά τα κτιτήρια");
            } else {
                searchTablePanel.setVisible(true);
                favoriteMoviesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                favoriteMoviesTable.getColumnModel().getColumn(0).setMinWidth(150);
                favoriteMoviesTable.getColumnModel().getColumn(1).setMaxWidth(90);
                favoriteMoviesTable.getColumnModel().getColumn(2).setMinWidth(200);

                int colCount = favoriteMoviesTable.getColumnCount();

                DefaultTableModel tModel = (DefaultTableModel) favoriteMoviesTable.getModel();
                tModel.setRowCount(0);
                Object[] ob = new Object[colCount];

                for (Movie m : filteredMovies) {
                    for (int row = 0; row < filteredMovies.size(); row++) {
                        ob[0] = m.getTitle();
                        String rating = new DecimalFormat("#.##").format(m.getRating());
                        ob[1] = rating;
                        ob[2] = m.getOverview();
                    }
                    tModel.addRow(ob);
                }
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        genreComboBox.setSelectedIndex(-1);
        yearTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void favoriteMoviesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favoriteMoviesTableMouseClicked
        //Get the movie title with sorted table listener
        DefaultTableModel model = (DefaultTableModel) favoriteMoviesTable.getModel();
        int selectedRowIndex = favoriteMoviesTable.getSelectedRow();
        System.out.println(model.getValueAt(favoriteMoviesTable.getRowSorter().convertRowIndexToModel(selectedRowIndex), 0));
        movieTitle = (model.getValueAt(favoriteMoviesTable.getRowSorter().convertRowIndexToModel(selectedRowIndex), 0)).toString();
        List<Movie> selectedMovies = controllerMovie.selectMovie(movieTitle);
        Movie m = selectedMovies.get(0);

        if (m.getFavoriteListId() != null) {
            List<FavoriteList> favoriteLists = controllerFavoriteList.findAll();
            FavoriteList favoriteList = controllerFavoriteList.findFavoriteListById(m.getFavoriteListId().getId());
            int idx = favoriteLists.indexOf(favoriteList);
            favoriteListComboBox.setSelectedIndex(idx);
        } else {
            favoriteListComboBox.setSelectedIndex(-1);
        }

    }//GEN-LAST:event_favoriteMoviesTableMouseClicked

    private void removeFromListButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeFromListButtonMouseClicked
        List<Movie> selectedMovies = controllerMovie.selectMovie(movieTitle);
        Movie m = selectedMovies.get(0);
        System.out.println(selectedMovies.get(0).getTitle());
        try {
            favoriteListComboBox.setSelectedIndex(-1);
            controllerMovie.updateMovie(m, null);
        } catch (IOException ex) {
            Logger.getLogger(GUIMainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GUIMainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeFromListButtonMouseClicked

    private void top10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top10ButtonActionPerformed
        top10Panel.setVisible(true);
        List<Movie> top10Movies = controllerMovie.findTop10Movies();
        top10Table.getColumnModel().getColumn(0).setMinWidth(150);
        top10Table.getColumnModel().getColumn(1).setMaxWidth(90);

        int colCount = top10Table.getColumnCount();

        DefaultTableModel tModel = (DefaultTableModel) top10Table.getModel();
        tModel.setRowCount(0);
        Object[] ob = new Object[colCount];

        for (Movie m : top10Movies) {
            for (int row = 0; row < top10Movies.size(); row++) {
                ob[0] = m.getTitle();
                String rating = new DecimalFormat("#.##").format(m.getRating());
                ob[1] = rating;
            }
            tModel.addRow(ob);
        }

    }//GEN-LAST:event_top10ButtonActionPerformed

    private void topPerListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topPerListButtonActionPerformed
        int colCount = topPerListTable.getColumnCount();
        DefaultTableModel tModel = (DefaultTableModel) topPerListTable.getModel();
        tModel.setRowCount(0);
        Object[] ob = new Object[colCount];
        List<FavoriteList> favoriteList = controllerFavoriteList.findAll();

        if (favoriteList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Δεν έχετε δημιουργήσει Λίστες αγαπημένων ταινιών");
        } else {
            topPerListPanel.setVisible(true);
            for (FavoriteList fl : favoriteList) {
                List<Movie> moviesByFL = controllerMovie.selectMovieByFavoriteList(fl);
                if (moviesByFL.size() != 0) {
                    ob[0] = moviesByFL.get(0).getTitle();
                    ob[1] = fl.getName();
                    tModel.addRow(ob);
                }
            }
        }
    }//GEN-LAST:event_topPerListButtonActionPerformed

    private void createButtonFLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonFLMouseClicked
        String newfavoriteList = JOptionPane.showInputDialog(null, "Παρακαλώ γράψτε το όνομα της νέας λίστας", "Εισαγωγή Νέας Λίστας", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(newfavoriteList);
        if (newfavoriteList != null) {
            controllerFavoriteList.persistFavoriteList(newfavoriteList);
            drawFL();
        }
    }//GEN-LAST:event_createButtonFLMouseClicked

    private void favoritListListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_favoritListListValueChanged
        String selectedList = "";
        if (!evt.getValueIsAdjusting()) {//This line prevents double events
            System.out.println(favoritListList.getSelectedValue());
            selectedList = favoritListList.getSelectedValue();
        }
        List<FavoriteList> favoriteList = controllerFavoriteList.selectFL(selectedList);
        if (favoriteList.size() != 0) {
            favoriteListMoviesPanel.setVisible(true);
            selectedFL = favoriteList.get(0);
            drawMoviesPerFavoriteList(selectedFL);
    }//GEN-LAST:event_favoritListListValueChanged
    }

    private void updateButtonFLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonFLMouseClicked
        List<String> fLnames = favoritListList.getSelectedValuesList();
        if (fLnames.size() != 1) {
            JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξετε μια λίστα για επεξεργασία!");
        } else {
            String newName = (String) JOptionPane.showInputDialog(null,
                    "Παρακαλώ αλλάξτε το όνομα της λίστας", "Επεξεργασία Λίστας", JOptionPane.WARNING_MESSAGE, null, null, fLnames.get(0));
            if (newName != null) {
                selectedFL.setName(newName);
                controllerFavoriteList.updateFavoriteList(selectedFL);
                drawFL();
            }
        }
    }//GEN-LAST:event_updateButtonFLMouseClicked

    private void deleteButtonFLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonFLActionPerformed
        List<String> fLnames = favoritListList.getSelectedValuesList();
        if (fLnames.size() == 0) {
            JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξετε τουλάχιστον μία λίστα για διαγραφή!");
        } else {
            String joined = String.join("\n", fLnames);
            Object[] options = {"Ναι", "Ακύρωση"};

            int n = JOptionPane.showOptionDialog(null,
                    "Είστε σίγουρος ότι θέλετε να διαγράψετε τις ακόλουθες λίστες?" + "\n" + joined,
                    "Προειδοποίηση",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            if (n == JOptionPane.YES_OPTION) {
                for (String name : fLnames) {
                    FavoriteList fl = controllerFavoriteList.selectFL(name).get(0);
                    controllerFavoriteList.deleteFavoriteList(fl);
                    drawMoviesPerFavoriteList(selectedFL);
                }
                drawFL();
            }
        }
    }//GEN-LAST:event_deleteButtonFLActionPerformed

    private void retrieveAndStoreMoviesSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveAndStoreMoviesSubMenuActionPerformed
        retrieveAndStoreMoviesActionPerformed(evt);
    }//GEN-LAST:event_retrieveAndStoreMoviesSubMenuActionPerformed

    private void searchMoviesSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMoviesSubMenuActionPerformed
        searchMovies(evt);
    }//GEN-LAST:event_searchMoviesSubMenuActionPerformed

    private void exitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMenuMouseClicked

    private void statisticsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsMenuMouseClicked
        switchPanels(statsPanel);
        top10Panel.setVisible(false);
        topPerListPanel.setVisible(false);
    }//GEN-LAST:event_statisticsMenuMouseClicked

    private void drawFL() {
        List<FavoriteList> favoriteLists = controllerFavoriteList.findAll();
        String[] FLarray = new String[favoriteLists.size()];
        for (int i = 0; i < favoriteLists.size(); i++) {
            FLarray[i] = favoriteLists.get(i).getName();
            System.out.println(FLarray[i]);

        }
        favoritListList.setListData(FLarray);
        favoritListList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void drawMoviesPerFavoriteList(FavoriteList favoriteList) {
        List<Movie> moviesByFL = controllerMovie.selectMovieByFavoriteList(favoriteList);

        favoriteListMoviesTable.getColumnModel().getColumn(0).setMinWidth(150);
        favoriteListMoviesTable.getColumnModel().getColumn(1).setMaxWidth(90);
        favoriteListMoviesTable.getColumnModel().getColumn(2).setMinWidth(300);

        for (Movie m : moviesByFL) {
            System.out.println(m.getTitle());
        }

        int colCount = favoriteListMoviesTable.getColumnCount();
        DefaultTableModel tModel = (DefaultTableModel) favoriteListMoviesTable.getModel();
        tModel.setRowCount(0);
        Object[] ob = new Object[colCount];

        for (Movie m : moviesByFL) {
            for (int row = 0; row < moviesByFL.size(); row++) {
                ob[0] = m.getTitle();
                String rating = new DecimalFormat("#.##").format(m.getRating());
                ob[1] = rating;
                ob[2] = m.getOverview();
            }
            tModel.addRow(ob);
        }
    }

    private void fetchFL() {
        List<FavoriteList> favoriteLists = controllerFavoriteList.findAll();
        String[] FLarray = new String[favoriteLists.size()];
        for (int i = 0; i < favoriteLists.size(); i++) {
            FLarray[i] = favoriteLists.get(i).getName();
            System.out.println(FLarray[i]);
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(FLarray);
        favoriteListComboBox.setModel(model);
    }

    private void fetchGenres() {
        List<Genre> genres = controllerGenre.findAll();
        String[] genreArray = new String[genres.size()];
        for (int i = 0; i < genres.size(); i++) {
            genreArray[i] = genres.get(i).getName();
            System.out.println(genreArray[i]);
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(genreArray);
        genreComboBox.setModel(model);
    }

    private List<FavoriteList> getSelectedLists() {
        System.out.println(favoritListList.getSelectedIndices());
        return Arrays.stream(favoritListList.getSelectedIndices()).boxed()
                .map(idx -> lists.get(idx))
                .collect(Collectors.toList());
    }

    private void switchPanels(JPanel panel) {
        LayeredPane.removeAll();
        LayeredPane.add(panel);
        LayeredPane.repaint();
        LayeredPane.revalidate();
    }

    class TaskInitialize extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() {
            try {
                controllerMovie.clearTable();
                controllerGenre.clearTable();
                controllerFavoriteList.clearTable();

                controllerGenre.retrieveAndPersistGenres();
                controllerMovie.retrieveAndPersistMovies();

            } catch (IOException ex) {
                Logger.getLogger(GUIMainMenu.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Κάτι δεν πήγε καλά!");
            } catch (ParseException ex) {
                Logger.getLogger(GUIMainMenu.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Κάτι δεν πήγε καλά!");
            }
            return null;
        }

        @Override
        protected void done() {
            progressPanel.setVisible(false);
            JOptionPane.showMessageDialog(null, "Επιτυχής ανάκτηση δεδομένων!");
            //progressDialog.setVisible(false);
        }
    }
    private void aboutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuMouseClicked
        switchPanels(aboutPanel);
    }//GEN-LAST:event_aboutMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MoviesMenu;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JPanel aboutPanel;
    private javax.swing.JTextArea abouttext;
    private javax.swing.JLabel addtoListLabel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton createButtonFL;
    private javax.swing.JButton deleteButtonFL;
    private javax.swing.JButton exit;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JList<String> favoritListList;
    private javax.swing.JComboBox<String> favoriteListComboBox;
    private java.util.List<gr.eap.mymovies.model.FavoriteList> favoriteListList;
    private java.util.List<gr.eap.mymovies.model.FavoriteList> favoriteListList1;
    private javax.swing.JPanel favoriteListMoviesPanel;
    private javax.swing.JTable favoriteListMoviesTable;
    private javax.persistence.Query favoriteListQuery;
    private javax.persistence.Query favoriteListQuery1;
    private javax.persistence.Query favoriteListQuery2;
    private javax.swing.JPanel favoriteListsPanel;
    private javax.persistence.Query favoriteListsQuery;
    private javax.swing.JTable favoriteMoviesTable;
    private javax.swing.JComboBox<String> genreComboBox;
    private javax.persistence.Query genreQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton manageFavoriteLists;
    private javax.swing.JMenuItem manageFavoriteListsSubMenu;
    private javax.swing.JMenu moviesListsMenu;
    private javax.persistence.EntityManager myMoviesPUEntityManager;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JButton removeFromListButton;
    private javax.swing.JButton retrieveAndStoreMovies;
    private javax.swing.JMenuItem retrieveAndStoreMoviesSubMenu;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchMovies;
    private javax.swing.JLabel searchMoviesLabel;
    private javax.swing.JMenuItem searchMoviesSubMenu;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel searchTablePanel;
    private javax.swing.JLabel selectGenreLabel;
    private javax.swing.JButton statistics;
    private javax.swing.JMenu statisticsMenu;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JButton top10Button;
    private javax.swing.JPanel top10Panel;
    private javax.swing.JTable top10Table;
    private javax.swing.JButton topPerListButton;
    private javax.swing.JPanel topPerListPanel;
    private javax.swing.JTable topPerListTable;
    private javax.swing.JButton updateButtonFL;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JTextField yearTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
