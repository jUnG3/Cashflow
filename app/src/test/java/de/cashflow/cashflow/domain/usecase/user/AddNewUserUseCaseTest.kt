package de.cashflow.cashflow.domain.usecase.user

import de.cashflow.domain.exception.UserExistsException
import de.cashflow.domain.hash.Hasher
import de.cashflow.domain.model.User
import de.cashflow.domain.repository.UserRepository
import de.cashflow.domain.usecase.UseCase
import de.cashflow.domain.usecase.user.AddNewUserUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddNewUserUseCaseTest {

    private var addNewUserUseCase: AddNewUserUseCase? = null

    @Mock
    private var userRepositoryMock: UserRepository? = null

    @Mock
    private var hasherMock: Hasher? = null

    @Mock
    private var callbackMock: UseCase.Callback<User>? = null

    @Before
    fun setup() {
        addNewUserUseCase = AddNewUserUseCase(userRepositoryMock!!, hasherMock!!)
    }

    @Test
    fun execute_usernameIsNotTaken_success() {
        var userMock = User("hello", "world")
        Mockito.`when`(userRepositoryMock!!.isUsernameTaken(userMock.username)).thenReturn(false)
        Mockito.`when`(hasherMock!!.hash(userMock.password)).thenReturn("HashedPassword")
        var saveUserMock = User(userMock.username, "HashedPassword")

        addNewUserUseCase!!.execute(userMock, callbackMock!!)

        Mockito.verify(callbackMock!!).onSuccess(saveUserMock)
    }

    @Test
    fun execute_usernameIsTaken_error() {
        var userMock = User("hello", "world")
        Mockito.`when`(userRepositoryMock!!.isUsernameTaken(userMock.username)).thenReturn(true)

        addNewUserUseCase!!.execute(userMock, callbackMock!!)
    }
}