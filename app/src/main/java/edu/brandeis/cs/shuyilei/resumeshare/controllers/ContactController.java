package edu.brandeis.cs.shuyilei.resumeshare.controllers;

import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import edu.brandeis.cs.shuyilei.resumeshare.adapters.ContactsAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.adapters.EducationAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.adapters.ExperienceAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.adapters.SkillAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.beans.Education;
import edu.brandeis.cs.shuyilei.resumeshare.beans.Experience;
import edu.brandeis.cs.shuyilei.resumeshare.models.ContactModel;
import edu.brandeis.cs.shuyilei.resumeshare.models.EducationModel;
import edu.brandeis.cs.shuyilei.resumeshare.models.ExperienceModel;
import edu.brandeis.cs.shuyilei.resumeshare.models.SkillModel;
import edu.brandeis.cs.shuyilei.resumeshare.models.UserModel;
import edu.brandeis.cs.shuyilei.resumeshare.views.activities.HomeActivity;

/**
 * Created by shuyilei on 11/18/16.
 */

public class ContactController {
    private Context context;
    private EducationModel educationModel;
    private SkillModel skillModel;
    private UserModel userModel;
    private ExperienceModel experienceModel;

    public ContactController(Context context){
        this.context=context;
    }
//
//    public ShowResume(EducationAdapter)

    public void showResume(final EducationAdapter educationAdapter, final ExperienceAdapter experienceAdapter, final SkillAdapter skillAdapter, final ListView lv_education,final ListView lv_experience, final ListView lv_skill){
        educationModel=new EducationModel(context);
        skillModel=new SkillModel(context);
        experienceModel=new ExperienceModel(context);

        educationModel.loadEducationFromRemote(((HomeActivity)context).getResumeAccount(),educationAdapter,lv_education);
        experienceModel.loadExperienceFromRemote(((HomeActivity)context).getResumeAccount(),experienceAdapter,lv_experience);
        skillModel.loadSkillFromRemote(((HomeActivity)context).getResumeAccount(),skillAdapter,lv_skill);

    }

    public void showInfo(final TextView mEmail,final TextView mName){
        userModel=new UserModel(context);
        userModel.showInfo(((HomeActivity)context).getResumeAccount(),mEmail,mName);
    }
}
