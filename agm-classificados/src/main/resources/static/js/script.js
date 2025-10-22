$(document).ready(function () {
  refreshFavCount();

  // Formulário novo anúncio
  $('#newAdForm').on('submit', function (e) {
    e.preventDefault();

    const title = $('#title').val().trim();
    const price = $('#price').val().trim();
    const desc = $('#desc').val().trim();
    const imgUrl = $('#imgUrl').val().trim();

    if (!title || !price || !desc) {
      alert('Por favor, preencha todos os campos obrigatórios.');
      return;
    }

    // Cria o card dinamicamente
    const newId = 'ad-' + Date.now();
    let cardHtml = `
      <div class="col-md-4 ad-card" data-id="${newId}">
        <div class="card mb-3 shadow-sm">
          ${imgUrl ? `<img src="${imgUrl}" class="card-img-top" alt="${title}">` : ""}
          <div class="card-body">
            <h5 class="card-title">${title}</h5>
            <p class="card-text">R$ ${price} • ${desc}</p>
            <div class="d-flex justify-content-between">
              <button class="btn btn-primary btn-sm view-details">Ver detalhes</button>
              <button class="btn btn-outline-secondary btn-sm add-fav">♥ Favoritar</button>
            </div>
          </div>
        </div>
      </div>`;

    // Verifica onde inserir (row ou lista)
    if ($('#adsList').length) {
      $('#adsList').prepend(cardHtml);
    } else if ($('#negociosList').length) {
      $('#negociosList').prepend(cardHtml);
    } else if ($('#jobsList').length) {
      // Para empregos (list-group)
      let jobHtml = `
        <div class="list-group-item d-flex justify-content-between align-items-start ad-card" data-id="${newId}">
          <div>
            <h5 class="mb-1">${title}</h5>
            <p class="mb-1 text-muted">R$ ${price} • ${desc}</p>
          </div>
          <div class="text-end">
            <button class="btn btn-sm btn-outline-secondary add-fav">♥ Favoritar</button>
            <button class="btn btn-sm btn-primary mt-2 view-details">Ver</button>
          </div>
        </div>`;
      $('#jobsList').prepend(jobHtml);
    }

    // Fecha modal e reseta form
    $('#newAdModal').modal('hide');
    this.reset();
  });
});
