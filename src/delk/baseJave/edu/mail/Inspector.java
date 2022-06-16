package delk.baseJave.edu.mail;

import static delk.baseJave.edu.mail.MainMail.BANNED_SUBSTANCE;
import static delk.baseJave.edu.mail.MainMail.WEAPONS;

/**
 * Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
 * если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
 * ("weapons" и "banned substance"), то он бросает IllegalPackageException.
 * Если он находит посылку, состоящую из камней (содержит слово "stones"),
 * то тревога прозвучит в виде StolenPackageException.
 * Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
 */
public class Inspector implements  MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (! (mail instanceof MailPackage) ) return mail;
        String contents = ((MailPackage) mail).getContent().getContent();
    if ( contents.contains(WEAPONS) || contents.contains(BANNED_SUBSTANCE) ) {
            System.out.println("Weapons!");
            throw new IllegalPackageException();
        }
        if ( contents.contains("stones") ) {
            throw new StolenPackageException();
        }
        return mail;
    }
}
