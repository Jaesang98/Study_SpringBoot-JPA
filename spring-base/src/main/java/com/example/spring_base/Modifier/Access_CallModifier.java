package com.example.spring_base.Modifier;

public class Access_CallModifier {
    public Access_Modifiers modify() {
        Access_Modifiers modifiers = new Access_Modifiers();

        modifiers.public_str = "수정가능";

        modifiers.default_str = "수정가능";

        modifiers.protected_str = "수정가능";

    //  modifiers.private_str = "수정불가능";

        return modifiers;
    }
}