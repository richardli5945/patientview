package com.solidstategroup.radar.web.pages.admin;

import com.solidstategroup.radar.model.filter.ProfessionalUserFilter;
import com.solidstategroup.radar.model.user.ProfessionalUser;
import com.solidstategroup.radar.util.TripleDes;
import com.solidstategroup.radar.web.RadarApplication;
import com.solidstategroup.radar.web.components.SearchField;
import com.solidstategroup.radar.web.components.SortLink;
import com.solidstategroup.radar.web.components.ClearLink;
import com.solidstategroup.radar.web.dataproviders.user.ProfessionalUserDataProvider;
import com.solidstategroup.radar.service.UserManager;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AdminUsersPage extends AdminsBasePage {

    @SpringBean
    private UserManager userManager;
    
    private static final int RESULTS_PER_PAGE = 10;

    public AdminUsersPage() {
        final ProfessionalUserDataProvider professionalUserDataProvider = new ProfessionalUserDataProvider(userManager);

        // TODO: need to hook these up
        add(new ExternalLink("exportPdf", ""));
        add(new ExternalLink("exportExcel", ""));
        
        add(new BookmarkablePageLink<AdminUserPage>("addNewUser", AdminUserPage.class));

        final WebMarkupContainer usersContainer = new WebMarkupContainer("usersContainer");
        usersContainer.setOutputMarkupId(true);
        add(usersContainer);

        final DataView<ProfessionalUser> userList = new DataView<ProfessionalUser>("users",
                professionalUserDataProvider) {
            @Override
            protected void populateItem(Item<ProfessionalUser> item) {
                builtDataViewRow(item);
            }
        };
        userList.setItemsPerPage(RESULTS_PER_PAGE);
        usersContainer.add(userList);

        // add paging element
        usersContainer.add(new AjaxPagingNavigator("navigator", userList));

        // add sort links to the table column headers
        for (Map.Entry<String, String> entry : getSortFields().entrySet()) {
            add(new SortLink(entry.getKey(), entry.getValue(), professionalUserDataProvider) {
                @Override
                public void onClicked(AjaxRequestTarget ajaxRequestTarget) {
                    userList.setCurrentPage(0);
                    ajaxRequestTarget.add(usersContainer);
                }
            });
        }

        // button to clear all the filter fields for each colum
        final ClearLink clearButton = new ClearLink("clearButton", professionalUserDataProvider, userList,
                usersContainer);
        add(clearButton);

        // add a search field to the top of each column - these will AND each search
        for (Map.Entry<String, String> entry : getFilterFields().entrySet()) {
            add(new SearchField(entry.getKey(), entry.getValue(), professionalUserDataProvider) {
                @Override
                public void onChanged(AjaxRequestTarget ajaxRequestTarget) {
                    userList.setCurrentPage(0);
                    ajaxRequestTarget.add(usersContainer);
                }
            });
        }
    }

    /**
     * Build a row in the dataview from the object
     * @param item Item<ProfessionalUser>
     */
    private void builtDataViewRow(Item<ProfessionalUser> item) {
        ProfessionalUser user = item.getModelObject();
        item.add(new BookmarkablePageLink<AdminUserPage>("edit", AdminUserPage.class,
                AdminUserPage.getPageParameters(user)));
        item.add(new Label("surname", user.getSurname()));
        item.add(new Label("forename", user.getForename()));
        item.add(new Label("title", user.getTitle()));
        item.add(new Label("role", user.getRole()));
        item.add(new Label("email", user.getEmail()));
        item.add(new Label("centre", user.getCentre().getName()));
        item.add(DateLabel.forDatePattern("dateRegistered", new Model<Date>(user.getDateRegistered()),
                RadarApplication.DATE_PATTERN));
        item.add(new Label("GMC", user.getGmc()));

        String username;
        try {
            username = TripleDes.decrypt(user.getUsernameHash());
        } catch (Exception e) {
            username = "";
        }

        item.add(new Label("username", username));

        String password;
        try {
            password = TripleDes.decrypt(user.getPasswordHash());
        } catch (Exception e) {
            password = "";
        }

        item.add(new Label("password", password));
    }

    /**
     * List of columns that can be used to sort the results - will return ID of el to be bound to and the field to sort
     * @return Map<String, ProfessionalUserFilter.UserField>
     */
    private Map<String, String> getSortFields() {
        return new HashMap<String, String>() {
            {
                put("orderBySurname", ProfessionalUserFilter.UserField.SURNAME.getDatabaseFieldName());
                put("orderByForename", ProfessionalUserFilter.UserField.FORENAME.getDatabaseFieldName());
                put("orderByTitle", ProfessionalUserFilter.UserField.TITLE.getDatabaseFieldName());
                put("orderByRole", ProfessionalUserFilter.UserField.ROLE.getDatabaseFieldName());
                put("orderByEmail", ProfessionalUserFilter.UserField.EMAIL.getDatabaseFieldName());
                put("orderByCentre", ProfessionalUserFilter.UserField.CENTRE.getDatabaseFieldName());
                put("orderByDateRegistered", ProfessionalUserFilter.UserField.REGISTRATION_DATE.getDatabaseFieldName());
                put("orderByGMC", ProfessionalUserFilter.UserField.GMC.getDatabaseFieldName());
            }
        };
    }

    /**
     * List of column filters - will return ID of el to be bound to and the field to filter
     * @return Map<String, ProfessionalUserFilter.UserField>
     */
    private Map<String, String> getFilterFields() {
        return new HashMap<String, String>() {
            {
                put("searchSurname", ProfessionalUserFilter.UserField.SURNAME.getDatabaseFieldName());
                put("searchForename", ProfessionalUserFilter.UserField.FORENAME.getDatabaseFieldName());
                put("searchTitle", ProfessionalUserFilter.UserField.TITLE.getDatabaseFieldName());
                put("searchRole", ProfessionalUserFilter.UserField.ROLE.getDatabaseFieldName());
                put("searchEmail", ProfessionalUserFilter.UserField.EMAIL.getDatabaseFieldName());
                put("searchCentre", ProfessionalUserFilter.UserField.CENTRE.getDatabaseFieldName());
                put("searchGMC", ProfessionalUserFilter.UserField.GMC.getDatabaseFieldName());
                // TODO: add the date filter
            }
        };
    }
}
