import DroidKaigiMPP
import FirebaseAuth
import Foundation

public class AuthenticatorImpl: Authenticator {

    public func currentUser(completionHandler: @escaping (DroidKaigiMPP.User?, Error?) -> Void) {
        guard let firebaseUser = Auth.auth().currentUser else {
            completionHandler(nil, nil)
            return
        }
        firebaseUser.getIDTokenResult { (result, error) in
            if let error = error {
                completionHandler(nil, error)
                return
            }

            completionHandler(DroidKaigiMPP.User(idToken: result?.token), nil)
        }
    }

    public func signInAnonymously(completionHandler: @escaping (DroidKaigiMPP.User?, Error?) -> Void) {
        Auth.auth().signInAnonymously { (result, error) in
            if let error = error {
                completionHandler(nil, error)
                return
            }

            guard let result = result else {
                completionHandler(DroidKaigiMPP.User(idToken: nil), nil)
                return
            }

            result.user.getIDTokenResult { (result, error) in
                if let error = error {
                    completionHandler(nil, error)
                    return
                }

                completionHandler(DroidKaigiMPP.User(idToken: result?.token), nil)
            }
        }
    }

}
