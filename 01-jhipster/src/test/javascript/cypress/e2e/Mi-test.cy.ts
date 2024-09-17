
describe('Tests personalizdos', () => {

  beforeEach(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login('admin', 'admin'); //! Uso de la API 
  });

  it('Validar existencia de botones en la barra de navegación', () => {
    cy.visit('');
      cy.contains('Home').should('be.visible');
      cy.contains('Entities').should('be.visible');
      cy.contains('Administration').should('be.visible');
      cy.contains('Language').should('be.visible');
      cy.contains('Account').should('be.visible');
  })

  it('Crear cliente', () => {
    cy.visit('');
    cy.get('#entity-menu > span > span').click();
    cy.get('.show > li:nth-child(3) > .dropdown-item').click();
    cy.get('[data-cy=entityCreateButton]').click();
    cy.get('[data-cy=firstName]').click();
    cy.get('[data-cy=firstName]').type('Pepe');
    cy.get('[data-cy=lastName]').type('Argento');
    cy.get('[data-cy=email]').type('pearg@gmail.com');
    cy.get('[data-cy=address]').type('1234');
    cy.get('[data-cy=phone]').type('1234');
    cy.get('#save-entity > span').click();
    cy.get('.ng-submitted').submit();
  })

  it('Eliminar cliente', () => {
    cy.visit('http://localhost:8080/client');
    cy.get('[data-cy="entityTable"]:nth-child(11) [data-cy="entityDeleteButton"] > .d-none').click();
    cy.get('#jhi-confirm-delete-client > span').click();
  })

});